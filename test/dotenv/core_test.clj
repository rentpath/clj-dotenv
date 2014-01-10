;; core_test.clj

;; Run with "env EVNIRONMENT=test lein test"

;; A .env.test file and a .env.local file must be present.


(ns dotenv.core-test
  (:require [clojure.test :refer :all]
            [com.rentpath.dotenv.core :as dotenv :refer :all]
            [com.rentpath.environs.core :as environs :refer :all]))

(defn environ-fixture
  [f]
  (let [environ (load-env)
        previous-environ (zipmap (keys environ) (map #(System/getProperty %) (keys environ)))]
    ;; setup environ
    (dotenv!)
    (f)
    ;; reset environ
        (doseq [[k v] previous-environ] (set-property! k v))))
(use-fixtures :each environ-fixture)

(deftest test-10
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_10")]
    (is (= result "http://localhost:3000")))))

(deftest test-11
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_11")]
    (is (= result "11")))))

(deftest test-12
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_12")]
    (is (= result "http://localhost:3000")))))

(deftest test-20
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_20")]
    (is (= result "http://localhost:3000")))))

(deftest test-21
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_21")]
    (is (= result "21")))))

(deftest test-22
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_22")]
    (is (= result "http://localhost:3000")))))

(deftest test-30
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_30")]
    (is (= result "http://localhost:3000")))))

(deftest test-31
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_31")]
    (is (= result "31")))))

(deftest test-32
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_32")]
    (is (= result "http://localhost:3000")))))

(deftest test-40
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_40")]
    (is (= result "http://localhost:3000")))))

(deftest test-41
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_41")]
    (is (= result "41")))))

(deftest test-42
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_42")]
    (is (= result "http://localhost:3000")))))

(deftest test-50
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_50")]
    (is (= result "http://localhost:3000")))))

(deftest test-51
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_51")]
    (is (= result "51")))))

(deftest test-52
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_52")]
    (is (= result "http://localhost:3000")))))

(deftest test-60
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_60")]
    (is (= result "http://localhost:3000")))))

(deftest test-61
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_61")]
    (is (= result "61")))))

(deftest test-62
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_62")]
    (is (= result "http://localhost:3000")))))

(deftest test-70
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_70")]
    (is (= result "http://localhost:3000")))))

(deftest test-71
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_71")]
    (is (= result "71")))))

(deftest test-72
  (testing "dotenv, should pass"
  (let [result (Env "DOTENV_TEST_VAL_72")]
    (is (= result "http://localhost:3000")))))

(deftest test-make-filename
  (with-redefs [com.rentpath.dotenv.core/get-env (constantly "qa")]
    (is (= (make-filename "foo") "foo/.env.qa")))
  (with-redefs [com.rentpath.dotenv.core/get-env (constantly nil)]
    (is (= (make-filename "foo") "foo/.env"))
    (is (= (make-filename) (str (Env "PWD")
                                (Env "file.separator")
                                ".env")))))

(deftest optional-dir-for-dotenv
  (testing "(dotenv!) can be called w/ optional arg for dir to search"
    (dotenv! (str (System/getenv "PWD") "/test"))
    (is (= (Env "DOTENV_OPT_ARG") "true"))))
