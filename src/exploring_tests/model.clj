(ns exploring-tests.model
  (:require [schema.core :as s]))

(def empty-queue clojure.lang.PersistentQueue/EMPTY)

(defn new-hospital
  []
  { :g-queue empty-queue
   :lab1 empty-queue
   :lab2 empty-queue
   :lab3 empty-queue })

(s/def PatientID s/Str)
(s/def Department (s/queue PatientID))
(s/def Hospital { s/Keyword Department})

