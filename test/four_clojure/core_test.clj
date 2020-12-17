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

(deftest palindrome-detector-test
  (is (= true (palindrome-detector [1 2 2 1])))
  (is (= false (palindrome-detector "abab")))
  (is (= true (palindrome-detector ""))))

(deftest fibonacci-seq-test
  (is (= [1 1 2 3 5 8] (fibonacci-seq 6)))
  (is (= [1 1 2 3 5 8 13 21] (fibonacci-seq 8)))
  (is (= [] (fibonacci-seq 0))))

(deftest maximum-number-test
  (is (= 80 (maximum-number 6 6 7 80)))
  (is (= 20 (maximum-number 8 5 7 0 20)))
  (is (= 0 (maximum-number 0 0 0))))

(deftest get-the-caps-test
  (is (= "ABT" (get-the-caps "ABrT1")))
  (is (= "HW" (get-the-caps "Hello Word")))
  (is (= "" (get-the-caps ""))))

(deftest duplicate-seq-test
  (is (= [1 1 2 2 5 5] (duplicate-seq [1 2 5])))
  (is (= '("a" "a" "c" "c" "c" "c") (duplicate-seq (list "a" "c" "c"))))
  (is (= [[1] [1] #{1} #{1}] (duplicate-seq [[1] #{1}]))))

(deftest set-intersection-test
  (is (= #{2 3} (set-intersection #{0 1 2 3} #{2 3 4 5})))
  (is (= #{ } (set-intersection #{0 1 2} #{3 4 5})))
  (is (= #{:a :c :d} (set-intersection #{:a :b :c :d} #{:c :e :a :f :d}))))

(deftest compress-seq-test
  (is (= [1 2 3] (compress-seq [1 1 1 2 3 3])))
  (is (= "abc" (apply str (compress-seq "aabbcc"))))
  (is (= [[1 2] [1 2 3] [4 5]]) (compress-seq [[1 2] [1 2] [1 2 3] [4 5] [4 5]])))

(deftest rrange-test
  (is (= [0 1 2 3 4 5 6 7 8 9] (rrange 0 10)))
  (is (= '[] (rrange 0 0)))
  (is (= [-1 0 1 2 3] (rrange -1 4))))

(deftest get-factorial-test
  (is (= 120 (get-factorial 5)))
  (is (= 5040 (get-factorial 7)))
  (is (= 6 (get-factorial 3))))

(deftest interleave-two-seqs-test
  (is (= '(1 :a 2 :b 3 :c) (interleave-two-seqs [1 2 3] [:a :b :c])))
  (is (= '([1] 1 [2] 2 [3] 3) (interleave-two-seqs [[1] [2] [3]] (list 1 2 3))))
  (is (= '(1 "A" 2 "B" 3 "C") (interleave-two-seqs [1 2 3] (list "A" "B" "C")))))

(deftest flatten-seq-test
  (is (= [1 2 4 5 6 7 8] (flatten-seq [1 [2] [4 5 6] [[[7]]8]])))
  (is (= '(4 :a 5 :v 7 8) (flatten-seq [4 [:a 5 [:v 7]] 8])))
  (is (= [] (flatten-seq [[[[[]] [[[[]]]]]]]))))

(deftest replicate-seq-test
  (is (= [] (replicate-seq [1 2 3] 0)))
  (is (= [[] [] [] "A" "A" "A" "B" "B" "B"] (replicate-seq [[] "A" "B"] 3)))
  (is (= [] (replicate-seq [] 5))))

(deftest interpose-seq-test
  (is (= [] (interpose-seq "," [])))
  (is (= ["a" ";" "b" ";" "c"] (interpose-seq ";" ["a" "b" "c"])))
  (is (= [:a :Z :b :Z :c] (interpose-seq :Z [:a :b :c]))))

(deftest drop-nth-item-test
  (is (= [1 3 5 7 9] (drop-nth-item [1 2 3 4 5 6 7 8 9] 2)))
  (is (= [[1 2] [3 4 5] [4 5]] (drop-nth-item [[1 2] [3 4 5] [5 6] [4 5]] 3)))
  (is (= [] (drop-nth-item [1 2 3 4 5 6 7 8 9 10] 1))))

(deftest split-seq-test
  (is (= '((1 2 3 4 5) (6 7 8 9 0)) (split-seq 5 [1 2 3 4 5 6 7 8 9 0])))
  (is (= '(() (1 2 3 4 5)) (split-seq 0 [1 2 3 4 5])))
  (is (= '((6 7) (8 9 0)) (split-seq 2 [6 7 8 9 0]))))

(deftest pack-seq-test
  (is (= '((1 1) (2 2) (4) (5 5)) (pack-seq [1 1 2 2 4 5 5])))
  (is (=  '((:A :A) (:B) (:c :c) (:D)) (pack-seq [:A :A :B :c :c :D])))
  (is (= ['(1)] (pack-seq [1]))))

(deftest map-construction-test
  (is (= {:a 1 :b 2 :c 3} (map-construction [:a :b :c] [1 2 3])))
  (is (=  {1 "one" 2 "two" 3 "three"} (map-construction [1 2 3 4] ["one" "two" "three"])))
  (is (=  {:foo "foo" :bar "bar"} (map-construction [:foo :bar] ["foo" "bar" "baz"]))))

(deftest greatest-common-divisor-test
  (is (=  3 (greatest-common-divisor 3 6)))
  (is (= 40 (greatest-common-divisor 120 80)))
  (is (= 33 (greatest-common-divisor 1023 858))))

(deftest function-composition-test
  (is (= [3 2 1] ((function-composition rest reverse) [1 2 3 4])))
  (is (= 5 ((function-composition (partial + 3) second) [1 2 3 4])))
  (is (= true ((function-composition zero? #(mod % 8) +) 3 5 7 9))))