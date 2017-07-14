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

(defn check-input [input lifes word hits]
  (if (match? input word)
    (game lifes word (conj hits input))
    (game (dec lifes) word hits)))

(defn game [lifes word hits]
  (if (= lifes 0)
    (lose-game)
    (if (match-whole-word? word hits)
      (win-game)
      (check-input (user-input!) lifes word hits))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
