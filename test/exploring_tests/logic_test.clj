(ns exploring-tests.logic-test
  (:require [clojure.test :refer :all])
  (:require [ exploring-tests.logic :refer :all]))

(deftest fits-in-queue?-test
  (testing "That it fits in the queue"
    (is (fits-in-queue? {:g-queue []} :g-queue)))

  (testing "That it doesn't  fit a new patient when the queue is the full"
    (is (not (fits-in-queue? {:g-queue [1 2 3 4 5]} :g-queue))))

  (testing "That it doesn't  fit a new patient when the queue is above the limit"
    (is (not (fits-in-queue? {:g-queue [1 2 3 4 5 6 ]} :g-queue))))

  (testing "That it fits a new patient when the queue is right below the limit"
    (is (fits-in-queue? {:g-queue [1 2 3 4]} :g-queue))
    (is (fits-in-queue? {:g-queue [1 2 ]} :g-queue)))

  (testing "that is does not fit in queue when department doesn't exists"
    (is (not (fits-in-queue? {:g-queue [1 2 3 4 ]} :x-ray))))

  )

