(ns four-clojure.core)

(defn a-nil-key
  "A nil Key: Given a key and map, returns true iff the map contains an entry with that key and its value is nil."
  [k m]
  (if (contains? m k)
  (nil? (k m))
  false))

(defn default-map
  "Default Map: Takes a default value and a sequence of keys and constructs a map."
  [v s]
  (reduce
   #(conj %1 {%2 v})
   {}
   s))

(defn get-last
  "Get-last: Returns the last element in a sequence."
  [s]
  (first (reverse s)))

(defn get-penultimate
  "Penultimate Element: Returns the second to last element from a sequence."
  [s]
  (second (reverse s)))

(defn get-nth
  "Nth Element: Returns the Nth element from a sequence."
  [s n]
  (first (drop n s)))

(defn count-seq
  "Count a Sequence: Returns the total number of elements in a sequence."
  [s]
  (reduce
   (fn [c v]
     (inc c))
   0
   s))

(defn sum-it-all
  "Sum It All Up: Returns the sum of a sequence number."
  [s]
  (reduce + s))

(defn odd-numbers
  "Find the odd numbers: Returns only the odd number of a sequence."
  [s]
  (filter odd? s))

(defn reverse-seq
  "Reverse a Sequence: Reverses a sequence."
  [s]
  (into '() s))

(defn palindrome-detector
  "Palindrome Detector: Returns true if the given sequence is a palindrome."
  [s]
  (if (contains? [0 1] (count s))
    true
    (and (= (first s) (last s)) (recur (drop-last (rest s))))))

(defn fibonacci-seq
  "Fibonacci Sequence: Returns the first X fibonacci numbers."
  [n]
  (take n
        (reduce (fn [l _]
                  (conj l (apply + (take-last 2 l)))) 
                [1 1] 
                (range n))))

(defn maximum-number
  "Maximum Number: Takes a variable number of parameters and returns the maximum number."
  [& n]
  (last (sort n)))

(defn get-the-caps
  "Get the Caps: Takes a string and returns a new string containing only the capital letters."
  [s]
  (->> s
       (filter #(Character/isUpperCase %))
       (apply str)))

(defn duplicate-seq
  "Duplicate a Sequence: Duplicates each element of a sequence."
  [s]
  (->> s
       (map #(repeat 2 %))
       (apply concat)))

(defn set-intersection
  "Set Intersection: Returns the intersection of two sets."
  [set1 set2]
  (set (filter #(contains? set1 %) set2)))

(defn compress-seq
  "Compress a Sequence: Removes consecutive duplicates from a sequence."
  [s]
  (reduce
    #(if (= (last %1) %2)
       %1
       (conj %1 %2))
    []
    s))


(defn rrange
  "Implement range: Creates a list of all integers in a given range."
  [initial stop]
  (loop [result [] e initial]
    (if (= e stop)
      result
      (recur (conj result e) (inc e)))))

(defn get-factorial
  "Factorial Fun: Calculates factorials."
  [n]
  (->> (+ n 1) (range 1) (apply *)))

(defn interleave-two-seqs
  "Interleave Two Seqs: Takes two sequences and returns the first item from each, then the second item from each, then the third, etc."
  [s1 s2]
  (mapcat list s1 s2))

(defn flatten-seq
  "Flatten a Sequence: Flatten a sequence."
  [s]
  (loop [acc [] lis s]
    (if (empty? lis)
      acc
      (let [f (first lis) r (rest lis)]
        (if (coll? f)
          (recur acc (concat f r))
          (recur (conj acc f) r))))))

(defn replicate-seq
  "Replicate a Sequence: Replicates each element of a sequence variable of a number time."
  [s n]
  (->> s
       (map #(repeat n %))
       (apply concat)))

(defn interpose-seq
  "Interpose a Seq: Separate the items by an arbitrary value."
  [v s]
  (->> s
       (mapcat #(list % v))
       (drop-last)))

(defn drop-nth-item
  "Drop Every Nth Item: Drops every Nth item from a sequence."
  [s v]
  (->> (map list (range 1 (inc (count s))) s)
       (filter #(not= 0 (mod (first %1) v)))
       (map last)))

(defn split-seq
  "Spit a Sequence: Slips a sequence into two parts. (split-at restricted)."
  [v s]
  (let [seq-size (count s) n (- seq-size v)]
    (list (take v s) (take-last n s))))

(defn pack-seq
  "Pack a Sequence: Packs consecutive duplicates into sub-list."
  [s]
  (partition-by identity s))

(defn map-construction
  "Map Construction: Takes a vector of keys and a vector values and constructs a map from them."
  [k v]
  (apply merge (map hash-map k v)))

(defn greatest-common-divisor
  "Greatest Common Divisor: Given two integers, returns the greatest common divisor."
  [a b]
  (->> (max a b)
       (range 1)
       (filter #(and (= 0 (mod a %)) (= 0 (mod b %))))
       (apply max)))

(defn function-composition
  "Function Composition: Allows you to create function compositions. The parameter list should take a variable number of functions, applies them from right-to-left."
  [& functions]
  (fn [& params]
    (let [rev (reverse functions)]
      (reduce
        #(%2 %1)
        (apply (first rev) params)
        (rest rev)))))