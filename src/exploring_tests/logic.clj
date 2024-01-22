(ns exploring-tests.logic)
;have error when department is nil because the result of function is 0
;(defn fits-in-queue?
;  [hospital department]
;  (-> hospital
;      department
;      count
;      (< 5)))

;adding when-let to get department and when it not passed that function return false

;working even when department is nil using when-let function
;(defn fits-in-queue
;  [hospital department]
;  (when-let [queue (get hospital department)]
;    (-> queue
;        count
;        (< 5))))

(defn fits-in-queue?
  [hospital department]
  (some-> hospital
      department
      count
      (< 5)))