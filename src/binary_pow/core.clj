(ns binary-pow.core)

(defn shifts [x]
  (->> x
       (iterate #(bit-shift-right % 1))
       (take-while pos?)))

(defn bits-be [x]
  (->> (shifts x)
       (map #(bit-and % 1))))

(defn square [x]
  (* x x))

(defn powers [x]
  (iterate square x))

(defn pow [x n]
  (cond (zero? n) 1
        (= 1 n) x
        :else (->> (interleave (powers x) (bits-be n))
                   (partition 2)
                   (map (partial reduce *))
                   (filter pos?)
                   (reduce *))))