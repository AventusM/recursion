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

;tehtävän pointtina näköjään yleistää ajattelu alkoista joukkoihin (vrt. max-element)
(defn longest-sequence [a-seq]
  (if (empty? (rest a-seq))
    (first a-seq)
    (seq-max (first a-seq)
             (longest-sequence (rest a-seq))))
  )

(longest-sequence [[1 2] [] [1 2 3]])
(longest-sequence [[1 2]])
(longest-sequence [])

;(or (and ...)) ei toimi -> käytettävä nested-if -> siis cond
(defn my-filter
  [pred? a-seq]
  (cond
    (empty? a-seq) a-seq
    (pred? (first a-seq)) (cons (first a-seq)
                                (my-filter pred? (rest a-seq)))
    :else (my-filter pred? (rest a-seq)))
  )


(my-filter odd? [1 2 3 4])
(my-filter (fn [x] (> x 9000)) [12 49 90 9001])
(my-filter even? [1 3 5 7])


(defn
  sequence-contains?
  [elem a-seq]
  (cond
    (empty? a-seq) false
    (not (= elem (first a-seq))) (sequence-contains? elem (rest a-seq))
    :else true)
  )

(sequence-contains? 3 [1 2 3])
(sequence-contains? 3 [4 7 9])
(sequence-contains? :pony [])

;yhdistetään kaksi edellistä tehtävää
;TOSI outo break. false ei tuottanut oikeaa tulosta. Kokeilu tyhjällä
;merkkijonolla toi "" kolmanteen testiin. Lopulta kokeilu () toi oikean tuloksen
(defn
  my-take-while
  [pred? a-seq]
  (cond
    (empty? a-seq) a-seq
    (pred? (first a-seq)) (cons (first a-seq)
                                (my-take-while pred? (rest a-seq)))
    :else ()
    )
  )

(my-take-while odd? [1 2 3 4])
(my-take-while odd? [1 3 4 5])
(my-take-while even? [1 3 4 5])
(my-take-while odd? [])

;Sen sijaan, että alkaisin copypasteamaan tehtävänantoa niin muistin clojure.set/unionin aiemmin ja pienen googlailun jälkeen
;ymmärsin, että halutun muodon sai käsittelemällä a-seq:ejä joukkoina ja lopuksi muuntamalla ne listamuotoon
;joko "into" tai "seq" - funktioiden avulla
(defn my-drop-while [pred? a-seq]
  (cond
    (empty? a-seq) a-seq
    :else (seq (clojure.set/difference (set a-seq) (my-take-while pred? (set a-seq)))))
  )

(my-drop-while odd? [1 2 3 4])
(my-drop-while odd? [1 3 4 5])
(my-drop-while even? [1 3 4 5])
(my-drop-while odd? [])

(defn seq=
  [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq))
      true
    ;Allaolevalla tarkistuksella saa nil vs tyhjä joukko haluttuun muotoon ILMAN aikavaativuudeltaan huonoa count - metodia
    (or (empty? a-seq) (empty? b-seq))
      false
    (= (first a-seq) (first b-seq))
      (seq= (rest a-seq) (rest b-seq))
    :else
      false)
  )

(seq= [1 2 4] '(1 2 4))
(seq= [nil 1] [nil])

;Muokataan esimerkkiä "Saving the list"
(defn
  my-map
  [f seq-1 seq-2]
  (if (or (empty? seq-1) (empty? seq-2))
    '()
    (cons (f (first seq-1) (first seq-2))
          (my-map f (rest seq-1) (rest seq-2))))
  )

(my-map + [1 2 3] [4 4 4])
(my-map + [1 2 3 4] [0 0 0])
(my-map + [1 2 3] [])

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

