(ns binary-pow.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [binary-pow.core :refer [pow]]))

(deftest binary-pow-test
  (testing "x^0 is 1"
    (is (= 1 (pow 2 0)))
    (is (= 1 (pow 0 0))))
  (testing "x^1 is x"
    (is (= 0 (pow 0 1)))
    (is (= 1 (pow 1 1)))
    (is (= 2 (pow 2 1))))
  (testing "x^2"
    (is (= 4 (pow 2 2)))
    (is (= 9 (pow 3 2))))
  (testing "x^3"
    (is (= 8 (pow 2 3)))
    (is (= 27 (pow 3 3))))
  (testing "2^10"
    (is (= 1024 (pow 2 10)))))
