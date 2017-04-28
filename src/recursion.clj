(ns recursion)

(defn
  product
  [coll]
  (if (empty? coll)
    1
    (* (first coll)
       (product (rest coll))))
  )

(product [])
(product [1 2 3])
(product [1 2 3 4])
(product [0 1 2])
(product #{2 3 4})


;(singleton? [nil]) aiheutti ongelman -> 'filtteröidään' siis vain false ulos (not (false? ...)) tyyliin
(defn
  singleton?
  [coll]
  (if (empty? coll)
    false
    (and (not (false? (first coll))) (empty? (rest coll))))
  )

(rest [1]) ;antaa tyhjän
(singleton? [1])
(singleton? #{2})
(singleton? [])
(singleton? [1 2 3])
(singleton? [nil])
(singleton? [1 nil])


(defn
  my-last
  [coll]
  (if (empty? (rest coll))
    (first coll)
    (my-last (rest coll)))
  )

(my-last [])
(my-last [1 2 3])
(my-last [2 5])

;yllättävän samanlainen päättely kuin edellisessä tehtävässä
(defn
  max-element
  [a-seq]
  (if (empty? (rest a-seq))
    (first a-seq)
    (max (first a-seq)
         (max-element (rest a-seq))))
  )

(max-element [2 4 1 4])
(max-element [2])
(max-element [])


(defn seq-max
  [seq-1 seq-2]
  (let [length-seq1 (count seq-1)
        length-seq2 (count seq-2)]

    (if (> length-seq1 length-seq2)
      seq-1
      seq-2))
  )


(seq-max [1] [1 2])
(seq-max [1 2] [3 4])
;(seq-max [3 4] [1 2]) Jälkimmäinen palautuu, jos pituus sama


(defn longest-sequence [a-seq]
  [:-])

(defn my-filter [pred? a-seq]
  [:-])

(defn sequence-contains? [elem a-seq]
  :-)

(defn my-take-while [pred? a-seq]
  [:-])

(defn my-drop-while [pred? a-seq]
  [:-])

(defn seq= [a-seq b-seq]
  :-)

(defn my-map [f seq-1 seq-2]
  [:-])

(defn power [n k]
  :-)

(defn fib [n]
  :-)

(defn my-repeat [how-many-times what-to-repeat]
  [:-])

(defn my-range [up-to]
  [:-])

(defn tails [a-seq]
  [:-])

(defn inits [a-seq]
  [:-])

(defn rotations [a-seq]
  [:-])

(defn my-frequencies-helper [freqs a-seq]
  [:-])

(defn my-frequencies [a-seq]
  [:-])

(defn un-frequencies [a-map]
  [:-])

(defn my-take [n coll]
  [:-])

(defn my-drop [n coll]
  [:-])

(defn halve [a-seq]
  [:-])

(defn seq-merge [a-seq b-seq]
  [:-])

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

