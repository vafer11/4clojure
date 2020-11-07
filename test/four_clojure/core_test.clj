(ns four-clojure.core-test
  (:require [clojure.test :refer :all]
            [four-clojure.core :refer :all]))

(deftest a-nil-key-test
  (is (= true (a-nil-key :a {:a nil :b 2})))
  (is (= false (a-nil-key :c {:a 1 :b 2})))
  (is (= false (a-nil-key :c {:a 1 :b 2 :c 3}))))

(deftest default-map-test
  (is (= {1 "a" 2 "a" 3 "a"} (default-map "a" [1 2 3])))
  (is (= {:a 0 :b 0 :c 0} (default-map 0 [:a :b :c])))
  (is (= {:a [1 2] :b [1 2]} (default-map [1 2] [:a :b]))))

(deftest get-last-test
  (is (= 2 (get-last '(1 3 2))))
  (is (= 5 (get-last [1 2 3 4 5])))
  (is (= [1 2] (get-last [1 2 [1 2] 3 [1 2]]))))

(deftest get-penultimate-test
  (is (= 4 (get-penultimate '(1 2 3 4 5))))
  (is (= 2 (get-penultimate [1 2 3])))
  (is (= [1 2] (get-penultimate [[1 2] 2]))))

(deftest get-nth-test
  (is (= 1 (get-nth '(1 2 3 4 5) 0)))
  (is (= 5 (get-nth '(1 2 3 4 5) 4)))
  (is (= [1 2] (get-nth [1 [1 2] [3 4]] 1))))

(deftest count-seq-test
  (is (= 5 (count-seq [1 2 5 6 7])))
  (is (= 3 (count-seq (list 1 2 3))))
  (is (= 0 (count-seq []))))

(deftest sum-it-all-test
  (is (= 7 (sum-it-all [0 5 2 0 0])))
  (is (= 0 (sum-it-all [])))
  (is (= 21 (sum-it-all [1 2 3 4 5 6]))))

(deftest reverse-seq-test
  (is (= [5 4 3 2 1] (reverse-seq [1 2 3 4 5])))
  (is (= '(7 5 2) (reverse-seq (sorted-set 7 5 7 2))))
  (is (= [[1 2] [3 4] [5 6]] (reverse-seq [[5 6] [3 4] [1 2]]))))
