(ns ^{:author "Jack Morrill for RentPath.com"
      :doc "Load environment variable definitions from .env into the JVM System Properties."}
      dotenv.core
      (:require [clojure.java.io :as io]
                [clojure.string :as string]
                [environs.core  :as environs]))

(defn exists?
  "Returns true if file exists and is a regular file, else returns false."
  [filename]
  (.isFile (io/file filename)))

(defn load-env

  "Load environment variable definitions from .env{.<environment>} into the JVM System Properties

  TODO:

  Currently dotenv reads .env if a file name is not passed to the function.  We need the concept
  of an environment, like Rails.env or RACK_ENV for Sinatra.  The dotenv function should lookup
  the file .env.<environment>, and if that is not found, fall back to .env

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

  [& {:keys [env-file]
      :or {env-file ".env"}}]
  (if (exists? env-file)
    (doseq [line (with-open [file (io/reader env-file)]
      (doall (line-seq file)))]
        (let [l (string/trim (string/replace line #"(^export\s+)|([#].*)" ""))]
          (if (or (not (string/blank? l)) (> (count l) 0))
            (let [v (string/split (string/replace l #"['\"]" "") #"(\s*=\s*)|(:\s+)")]
              (= (count v) 2 (System/setProperty (str (v 0)) (v 1)))))))))

