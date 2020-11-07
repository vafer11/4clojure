(ns four-clojure.core)

; A nil Key: Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
(defn a-nil-key [k m]
  (if (contains? m k)
  (nil? (k m))
  false))

; Default Map: Write a function which takes a default value and a sequence of keys and constructs a map.
(defn default-map [v s]
  (reduce
   #(conj %1 {%2 v})
   {}
   s))

; Get-last: Write a function which returns the last element in a sequence.
(defn get-last [s]
  (first (reverse s)))

; Penultimate Element: Write a function which returns the second to last element from a sequence.
(defn get-penultimate [s]
  (second (reverse s)))

; Nth Element: Write a function which returns the Nth element from a sequence.
(defn get-nth [s n]
  (first (drop n s)))

; Count a Sequence: Write a function which returns the total number of elements in a sequence.
(defn count-seq [s]
  (reduce
   (fn [c v]
     (inc c))
   0
   s))

; Sum It All Up: Write a function which returns the sum of a secuence number
(defn sum-it-all [s]
  (reduce + s))

; Find the odd numbers: Write a function which returns only the odd number of a secuence 
(fn [s]
  (filter odd? s))

; Reverse a Sequence: Write a function which reverses a secuence
(defn reverse-seq [s]
  (into '() s))

; Polindrome Detector: Write a function which returns true if the given sequence is a polindrome 
(fn [s]
  (if (contains? [0 1] (count s))
    true
    (and (= (first s) (last s)) (recur (drop-last (rest s))))))

; Fibonacci Sequence: Write a function which returns the first X fibonacci numbers
(fn [n]
  (take n
        (reduce (fn [l _]
                  (conj l (apply + (take-last 2 l)))) 
                [1 1] 
                (range n))))

; Maximum Number: Write a function which takes a variable number of parameters and returns the maximun number
(fn [& n] 
  (last (sort n)))

; Get the Caps: Write a function which takes a string and returns a new string containing only the capital letters
(fn [s]
  (->> s
       (filter #(Character/isUpperCase %))
       (apply str)))

; Duplicate a Sequence: Write a function which duplicates each element of a sequence
(fn [s]
  (->> s
       (map #(repeat 2 %))
       (apply concat)))

;Compress a Sequence: Write a function which removes consecutive duplicates from a sequence
(fn [s]
  (->> s
       (dedupe)
       (apply str)))

; Implement range: Write a function which creates a list of all integers in a given range.
(fn [initial stop]
  (loop [result [] e initial]
    (if (= e stop)
      result
      (recur (conj result e) (inc e)))))

; Factorial Fun: Write a function which calculates factorials.
(fn [n]
  (->> n (+ 1) (range 1) (apply *)))

; Interleave Two Seqs: Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.
(fn [s1 s2]
  (mapcat list s1 s2))

; Flatten a Sequence: Write a functon which flatten a sequence
(fn [s]
  (loop [acc [] lis s]
    (if (empty? lis)
      acc
      (let [f (first lis) r (rest lis)]
        (if (coll? f)
          (recur acc (concat f r))
          (recur (conj acc f) r))))))

; Replicate a Sequence: Write a function which each element of a sequance variable of a number time
(fn [s n]
  (->> s
       (map #(repeat n %))
       (apply concat)))

; Interpose a Seq: Write a function which separate the items by an arbitrary value
(fn [v s]
  (->> s
       (mapcat #(list % v))
       (drop-last)))

; Drop Every Nth Item: Write a function which drops every Nth item from a sequence
(fn [s v]
  (->> (map list (range 1 (inc (count s))) s)
       (filter #(not= 0 (mod (first %1) v)))
       (map last)))

; Spit a Sequence: Write a function which slips a sequence into two parts. (split-at restricted)
(fn [v s]
  (let [seq-size (count s) n (- seq-size v)]
    (list (take v s) (take-last n s))))

; Pack a Sequence: Write a fuction which packs consecutive duplicates into sub-list
(fn [s]
  (partition-by identity s))

; Map Construction: Write a function which takes a vector of keys and a vector values and constracts a map from them.
(fn [k v]
  (apply merge (map hash-map k v)))
