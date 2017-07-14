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

(defn game [lifes word hits]
  (if (= lifes 0)
    (lose-game)
    (if (match-whole-word? word hits)
      (win-game)
      (print "Try again!"))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
