(ns forca.core
  (:gen-class))

(def max-lifes 6)

(def secret-word "PINEAPPLE")

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

(defn print-hangman [lifes word hits]
  (println "Lifes " lifes)
  (doseq [letter (seq word)]
      (if (contains? hits (str letter))
        (print letter " ")
        (print "_" " ")))
  (println))

(defn game [lifes word hits]
  (print-hangman lifes word hits)
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

(defn start-game [] (game max-lifes secret-word #{}))

(defn -main
  [& args]
  (start-game))
