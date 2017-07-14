(ns forca.core
  (:gen-class))

(def max-health 6)

(defn lose-game [] (print "You lose!"))

(defn win-game [] (print "You win!"))

(defn missing-letters [word hits]
  (remove
    (fn [letter] (contains? hits (str letter)))
    word))

(defn match-whole-word? [word hits]
  (empty? (missing-letters word hits)))

(defn user-input! [] (read-line))

(defn match? [input word] (.contains word input))

(defn game [lifes word hits]
  (cond
    (= lifes 0) (lose-game)
    (match-whole-word? word hits) (win-game)
    :else
    (let [input (user-input!)]
      (if (match? input word)
        (do
          (println "Match a letter!")
          (recur lifes word (conj hits input)))
        (do
          (println "Sorry, wrong letter! You lose 1 life!")
          (recur (dec lifes) word hits))))))

(defn sum-series [n]
  (loop [res 0 acc 1]
    (if
      (= (- acc 1) n) res
      (recur (+ acc res) (inc acc)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
