(ns advent-of-code-2023.core
  (:require [clojure.java.io :as io]))

(defn lazy-file-lines [file]
  (letfn [(helper [rdr]
            (lazy-seq
             (if-let [line (.readLine rdr)]
               (cons line (helper rdr))
               (do (.close rdr) nil))))]
    (helper (io/reader file))))


(defn dayOnePartOne [inputFile]
  (println (apply + (map (fn [x] (Integer. (clojure.string/join (concat (pr-str (Integer. (re-find  #"\d{1}" x)))
                                                                        (pr-str (Integer. (re-find  #"\d{1}" (apply str (reverse x))))))))) (lazy-file-lines inputFile)))))

(defn -main []
  (println "Begin the advent! ...")
  (dayOnePartOne "input/dayOnePart1.dat"))