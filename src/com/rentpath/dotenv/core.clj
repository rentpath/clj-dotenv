(ns ^{:author "Jack Morrill, RentPath.com"
      :doc "Load environment variable definitions from .env<.environment> file into the JVM System Properties."}
      com.rentpath.dotenv.core
      (:require [clojure.java.io :as io      ]
                [clojure.string  :as string  ]
                [com.rentpath.environs.core   :as environs]
                [me.raynes.fs    :as fs      ]))

(def ^{:doc "An environment variable that specifies which environment we're running in."}
  +dot-env-var+
  "ENVIRONMENT")

(def +env-config-files+
  {"ci"          ".ci"
   "development" ".development"
   "test"        ".test"
   "acceptance"  ".acceptance"
   "production"  ".production"
   "qa"          ".qa"
   "stage"       ".stage"})

(defn exists?
  "Returns true if file exists and is a regular file, else returns false."
  [filename]
  (.isFile (io/file filename)))

(defn- get-env
  [varname]
  (get (System/getenv) varname))

(defn make-filename
  ([directory]
     (let [env (get-env +dot-env-var+)]
       (->> (str ".env" (.toLowerCase (get +env-config-files+ env "")))
            (vector directory)
            (string/join (System/getProperty "file.separator"))
            (fs/expand-home))))
  ([]
     (make-filename (System/getenv "PWD"))))

(defn set-property!
  [k v]
  (when (and k v)
    (System/setProperty k v)))

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
  ([]
     (load-env (make-filename)))
  ([config-filename]
     (if (exists? config-filename)
       (with-open [file (io/reader config-filename)]
         (->> (line-seq file)
              (map #(string/replace % #"(^export\s+)|([#].*)" ""))
              (map string/trim)
              (remove string/blank?)
              (map #(string/replace % #"['\"]" ""))
              (map #(string/split % #"(\s*=\s*)|(:\s+)"))
              (into {})))
       (throw (Error. (format "Could not load configuration file: %s" config-filename))))))
