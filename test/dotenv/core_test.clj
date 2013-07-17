(ns dotenv.core-test
  (:require [clojure.test :refer :all]
            [dotenv.core :as dotenv :refer :all]
            [environs.core :as environs :refer :all]))

(deftest test-10
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_10"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-11
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_11"))
    (is (= result "11"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-12
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_12"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-20
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_20"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-21
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_21"))
    (is (= result "21"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-22
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_22"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-30
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_30"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-31
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_31"))
    (is (= result "31"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-32
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_32"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-40
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_40"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-41
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_41"))
    (is (= result "41"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-42
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_42"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-50
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_50"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-51
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_51"))
    (is (= result "51"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-52
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_52"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-60
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_60"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-61
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_61"))
    (is (= result "61"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-62
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_62"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-70
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_70"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-71
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_71"))
    (is (= result "71"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

(deftest test-72
  (testing "dotenv, should pass"
  (dotenv/load-env)
  (try
    (def result (environs/get-env "DOTENV_TEST_VAL_72"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))

