(ns dotenv.core-test
  (:require [clojure.test :refer :all]
            [dotenv.core :refer :all]))

(deftest a-test
  (testing "dotenv, I fail."
    (is (= 0 1))))
