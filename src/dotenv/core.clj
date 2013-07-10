(ns ^{:author "Jack Morrill"
      :doc "Load environment variable definitions from .env into the JVM System Properties."}
      dotenv.core
      (:require [clojure.java.io :as io]
                [clojure.string :only (split)]))

(defn dotenv
  "Load environment variable definitions from .env into the JVM System Properties"
    (doseq [line (with-open [file (io/reader ".env")]
      (doall (line-seq file)))]
      (println (split line #"(\s*=\s*)|(:\s++)"))))


