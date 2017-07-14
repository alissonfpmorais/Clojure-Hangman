(ns forca.core
  (:gen-class))

(def max-health 6)

(defn end-game [] (print "You lose!"))

(defn game [lifes]
  (if (= lifes 0)
    (end-game)
    (do
      (print lifes)
      (game (dec lifes)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
