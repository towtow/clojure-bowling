(ns bowling)

(def number-of-frames 10)

(def number-of-pins 10)

(defn sum-first [n xs]
  (reduce + (take n xs)))

(defn open? [throws]
  (< (sum-first 2 throws) number-of-pins))

(defn strike? [throws]
  (= (first throws) number-of-pins))

(defn open-score [throws]
  (sum-first 2 throws))

(defn bonus-score [throws]
  (sum-first 3 throws))

(defn frame-score [throws]
  (if (open? throws) (open-score throws) (bonus-score throws)))

(defn score [all-throws]
  (loop [throws all-throws
         total-score 0
         current-frame 1]
    (if (> current-frame number-of-frames)
      total-score
      (let [remaining-throws (if (strike? throws) (next throws) (nnext throws))
            new-total-score (+ total-score (frame-score throws))
            next-frame (inc current-frame)]
        (recur remaining-throws new-total-score next-frame)))))
