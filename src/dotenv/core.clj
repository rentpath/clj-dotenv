(ns ^{:author "Jack Morrill"
      :doc "Load environment variable definitions from .env into the JVM System Properties."}
      dotenv.core
      (:require [clojure.java.io :as io]
                [clojure.string :as string]))

(defn exists?
  "Returns true if file exists and is a regular file, else returns false."
  [filename]
  (.isFile (io/file filename)))

(defn load-env
  "Load environment variable definitions from .env{.<environment>} into the JVM System Properties"
  [& {:keys [env-file]
      :or {env-file ".env"}}]
    (if (exists? env-file)
      (doseq [line (with-open [file (io/reader env-file)]
        (doall (line-seq file)))]
          (if (not (string/blank? line))
            (let [l (string/trim line)]
              (let [v (string/split l #"(\s*=\s*)|(:[^/])")]
                (= (count v) 2 (System/setProperty (str (nth v 0)) (str (nth v 1))))))))))

