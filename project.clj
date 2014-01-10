(defproject dotenv "1.0.3"
  :description "dotenv: Load environment variables from .env file into JVM System Properties"
  :url "https://github.com/primedia/clj-dotenv"
  :license {:name "MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[ org.clojure/clojure   "1.5.1" ]
                 [ me.raynes/fs          "1.4.0" ]]
  :profiles {:test
             {:dependencies [[com.rentpath/environs "1.1.0"]]}}
  ;; :repositories {"project" "file:repo"})
  :repositories [["iws_pair" "http://ec2-54-224-24-95.compute-1.amazonaws.com/maven/.m2"]])
