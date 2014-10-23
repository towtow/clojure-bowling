(ns bowling-tests
  (:use bowling clojure.test))

(deftest sum-first-test
  (is (= 0 (sum-first 0 [1 2 3 4 5])))
  (is (= 1 (sum-first 1 [1 2 3 4 5])))
  (is (= 3 (sum-first 2 [1 2 3 4 5])))
  (is (= 6 (sum-first 3 [1 2 3 4 5])))
  (is (= 15 (sum-first 5 [1 2 3 4 5])))
  (is (= 15 (sum-first 100 [1 2 3 4 5]))))

(deftest open?-test
  (is (open? [1 2 3 4 5]))
  (is (open? [1 2]))
  (is (open? [5 4 1]))
  (is (not (open? [2 8])))
  (is (not (open? [1 9 2])))
  (is (not (open? [10])))
  (is (not (open? [10 0]))))

(deftest strike?-test
  (is (strike? [10]))
  (is (strike? [10 0]))
  (is (strike? [10 9 1]))
  (is (not (strike? [1])))
  (is (not (strike? [1 10])))
  (is (not (strike? [1 2])))
  (is (not (strike? [8 1 3 4])))
  (is (not (strike? [2 8]))))

(deftest open-score-test
  (is (= 3 (open-score [1 2 3 4 5])))
  (is (= 7 (open-score [4 3 1]))))

(deftest bonus-score-test
  (is (= 15 (bonus-score [8 2 5 3 2])))
  (is (= 30 (bonus-score [10 10 10 10])))
  (is (= 18 (bonus-score [10 5 3]))))

(deftest frame-score-test
  (is (= 3 (frame-score [1 2 3 4 5])))
  (is (= 7 (frame-score [4 3 1])))
  (is (= 15 (frame-score [8 2 5 3 2])))
  (is (= 30 (frame-score [10 10 10 10])))
  (is (= 18 (frame-score [10 5 3]))))

(deftest score-test
  (is (= 125 (score [1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 7])))
  (is (= 133 (score [1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6])))
  (is (= 149 (score [1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 10, 8, 6])))
  (is (= 300 (score [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))))

;(run-tests 'bowling-tests)
