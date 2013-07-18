(defproject dotenv "0.1.0"
  :description "dotenv: Load environment variables from .env file into the JVM System Properties"
  :url "https://github.com/primedia/clj-dotenv"
  :dependencies [ [org.clojure/clojure "1.5.1"]
                  [org.clojars.jackmorrill/dotenv   "0.1.0"]
                  ;;[local/dotenv.core "0.1.0"]
                  [org.clojars.jackmorrill/environs "0.1.0"]
                  ;;[local/environs.core "0.1.0"]
                ]
  :repositories {"project" "file:repo"})
