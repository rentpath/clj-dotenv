(ns ^{:author "Jack Morrill, RentPath.com"
      :doc "Load environment variable definitions from .env<.environment> file into the JVM System Properties."}
      dotenv.core
      (:require [clojure.java.io :as io      ]
                [clojure.string  :as string  ]
                [environs.core   :as environs]
                [me.raynes.fs    :as fs      ]))

(def ^{:doc "An environment variable that specifies which environment we're running in."}
  +dot-env-var+
  "CLJ_ENV")

(defn- exists?
  "Returns true if file exists and is a regular file, else returns false."
  [filename]
  (.isFile (io/file filename)))

(defn- get-env
  [varname]
  (get (System/getenv) varname))

(defn- set-property!
  [k v]
  (when (and k v)
    (System/setProperty k v)))

(defn- line->kv
  [line]
  (let [[k v]
        (-> line
            (string/replace #"['\"]" "")
            (string/replace #"(^export\s+)|([#].*)" "")
            (string/split #"(\s*=\s*)|(:\s+)")
            ((partial remove string/blank?)))]
    (when (and k v)
      (map string/trim [k v]))))

(defn- env-conf->map
  [config-filename]
  (if (exists? config-filename)
    (let [lines (-> (slurp config-filename) (string/split #"\n"))
          kvs (remove nil? (map line->kv lines))]
     (reduce
      (fn [agg [k v]]
        (assoc agg k v))
      {}
      kvs))
    (throw (Error. (format "Could not load configuration file: %s" config-filename)))))

(defn- write-properties-to-env
  [properties]
  (for [[k v] properties]
    (set-property! k v)))

;; Public API

(defn conf-file-path
  [& {:keys [env path] :or {env (or (get-env +dot-env-var+)
                                    "development")
                            path (System/getenv "PWD")}}]
  (let [env-filename (str ".env." (.toLowerCase (or env "")))
        rel-path-to-file 
        (str path (System/getProperty "file.separator") env-filename)]
    (fs/expand-home rel-path-to-file)))

(defn load-env
  "Load environment variable definitions from .env{.<environment>} into a map

  .env(.*) file format:

    foo=1
    bar='hairy URL'

  YAML-like format:

    foo: 1
    bar: 'hairy URL'

  For convienence, a Bourne Shell format is accepted:

    export foo=1
    export bar='hairy URL'

  "
  [config-filename]
  (let [prop-map (env-conf->map config-filename)
        _ (write-properties-to-env prop-map)]
    prop-map))
