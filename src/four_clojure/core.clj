(ns four-clojure.core)


; #134
; A nil Key: Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
(fn [k m]
  (if (contains? m k)
  (nil? (k m))
  false))


; #156
;Default Map: Write a function which takes a default value and a sequence of keys and constructs a map.
(fn [v s]
  (reduce
   #(conj %1 {%2 v})
   {}
   s))


; #19
; Write a function which returns the last element in a sequence.
(fn [s]
  (first (reverse s)))



; #20
; Penultimate Element: Write a function which returns the second to last element from a sequence.
(fn [s]
  (second (reverse s)))


; 21
; Nth Element: Write a function which returns the Nth element from a sequence.
(fn [s n]
  (first (drop n s)))
