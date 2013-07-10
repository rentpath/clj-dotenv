(ns dotenv.core)

(require '[clojure.java.io :as io])

(use '[clojure.string :only (split)])

(doseq [line (with-open [file (io/reader ".env")]
  (doall (line-seq file)))]
    (println (split line #"(\s*=\s*)|(:\s++)")))


