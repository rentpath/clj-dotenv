;; src/dotenv/core.clj

;; Clojure implimentation of the doteng Ruby Gem.

(ns ^{:author "Jack Morrill"
      :doc "Load environment variable definitions from .env{.environment}, .env.local files into the JVM System Properties."}
      com.rentpath.dotenv.core
      (:require [clojure.java.io :as io ]
                [clojure.string  :as str]
                [me.raynes.fs    :as fs ]
                [clojure.pprint  :as pp ]))

(def ^{:doc "An environment variable that specifies which environment we're running in."}
  +dot-env-var+
  "ENVIRONMENT")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; File handling

(def +env-base+ ".env")


(defn- pwd [] (System/getenv "PWD"))
(defn- env [] (System/getenv +dot-env-var+))

(defn env-filename
  "returns .env.qa assuming env var named by +dot-env-var+ equals qa
   returns .env if env var named by +dot-env-var+ equals nil or empty string"
  []
  (str +env-base+ (when-not (str/blank? (env))
                    (str "." (env)))))

(defn set-property!
  [k v]
  (and k v (System/setProperty k v)))

(defn read-env-file
  "read environment variable definitions from file into a map."
  ([^java.io.File file]
   (when (.isFile file)
     (try
       (with-open [rdr (io/reader file)]
         (->> (line-seq rdr)
              (map #(str/replace % #"(^export\s+)|([#].*)" ""))
              (map str/trim)
              (remove str/blank?)
              (map #(str/replace % #"[']" "\""))
              (map #(str/split % #"(\s*=\s*)|(:\s+)"))
              (map (fn [[k v]]
                     (case v
                       "\"\"" [k  ""]
                       nil    [k nil]
                       [k (str/replace v #"[\"]" "")])))
              (into {})))
       (catch java.lang.Throwable e
         (.printStackTrace e)
         (throw (Error. (format "Could not load configuration file: %s" (.getCanonicalPath file)))))))))

(defn load-env
  ([]
   (load-env (io/file (pwd) (env-filename))))

  ([f]
   (read-env-file f)))


(let [+env-local+ ".env.local"]
  (defn dotenv!
    "Create JVM System Properties from environment variables defined in .env{.ENVIRONMENT}.
    If .env.local exists, load those JVM System Properties too, overriding definitions from .env{.environment}.

    .env.* file format:

      foo=1
      bar='hairy URL'

    YAML-like format:

      foo: 1
      bar: 'hairy URL'

    For convienence, a BASH Shell format is accepted:

      export foo=1
      export bar='gnarley URL'

    Blank lines and all characters after a comment character (#) in all lines are ignored.  
  
    Takes an optional argument specifying the directory to search for .env file 
    "
    ([] (dotenv! (pwd)))

    ([dir]
       (let [defaults  ((comp load-env io/file) dir (env-filename))
             override  ((comp load-env io/file) dir +env-local+)
             app-props (merge {} defaults override)]
         (doseq [[k v] app-props]
           (set-property! k v))))))
