(ns binary-pow.core)

(defn shifts [x]
  (->> x
       (iterate #(bit-shift-right % 1))
       (take-while pos?)))

(defn bits [x]
  (->> (shifts x)
       (map #(bit-test % 0))))

(defn square [x]
  (* x x))

(defn powers [x]
  (iterate square x))

(defn pow [x n]
  (->> (interleave (powers x) (bits n))
       (partition 2)
       (filter second)
       (map first)
       (reduce *)))
