(ns exploring-tests.logic-test
  (:require [clojure.test :refer :all])
  (:require [exploring-tests.logic :refer :all]))

(deftest fits-in-queue?-test
  (testing "That it fits in the queue"
    (is (fits-in-queue? {:g-queue []} :g-queue)))

  (testing "That it doesn't  fit a new patient when the queue is the full"
    (is (not (fits-in-queue? {:g-queue [1 2 3 4 5]} :g-queue))))

  (testing "That it doesn't  fit a new patient when the queue is above the limit"
    (is (not (fits-in-queue? {:g-queue [1 2 3 4 5 6]} :g-queue))))

  (testing "That it fits a new patient when the queue is right below the limit"
    (is (fits-in-queue? {:g-queue [1 2 3 4]} :g-queue))
    (is (fits-in-queue? {:g-queue [1 2]} :g-queue)))

  (testing "that is does not fit in queue when department doesn't exists"
    (is (not (fits-in-queue? {:g-queue [1 2 3 4]} :x-ray)))))

(deftest arrived-at-test
  (testing "that the new patient will be added to the department if the queue is not full "
    ;bad implementation only tests if what you wrote here the same that you wrote in the function
    ;that's obvious

    ;(is (= (update {:g-queue [1423]} :g-queue conj 5)
    ;       (arrived-at {:g-queue [1423]}, :g-queue, 5)))
    ;
    ;(is (= (update {:g-queue [14]} :g-queue conj 5)
    ;       (arrived-at {:g-queue [14]}, :g-queue, 5)))

    (is (= {:hospital {:g-queue [1 4 2 3 5]}, :result :success}
           (arrived-at {:g-queue [1 4 2 3]}, :g-queue, 5)))

    (is (= {:hospital {:g-queue [1 4 5]}, :result :success}
           (arrived-at {:g-queue [1 4]}, :g-queue, 5)))
    )
  (testing "that it won't add new patient to the queue when the queue is full"
    ;classic terrible coding the Exception is too generic
    ;(is (thrown? clojure.lang.ExceptionInfo
    ;     (arrived-at {:g-queue [1 58 96 74 32]}, :g-queue, 47)))

    ;test with try catch and check de exception
    ;(is (try (arrived-at {:g-queue [4 5 6 7 10]}, :g-queue, 47)
    ;    false
    ;    (catch clojure.lang.ExceptionInfo e
    ;      (= :impossible-to-add-patient-to-the-queue (:type (ex-data e)))))))
    ;

    (is (= {:hospital {:g-queue [1 4 5 7 3]}, :result :impossible-to-add-patient-to-the-queue}
           (arrived-at {:g-queue [1 4 5 7 3]}, :g-queue, 47)
           ))
     )
    )