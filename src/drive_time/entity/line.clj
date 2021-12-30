(ns drive-time.entity.line
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            [java-time :as java-time]
           ; [clj-time.core :as t]
            ))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/drive-time"
               :user "root"
               :password "java"
               :zeroDateTimeBehavior "convertToNull"})

(defn allLines []
  (jdbc/query mysql-db
              ["SELECT * FROM publiclines pl"]))


(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM publiclines WHERE id = ?" id])))

(defn removeLine [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM publiclines WHERE id = ?" id]))

(defn updateLine [id params]
  (jdbc/update! mysql-db :publiclines params (sql/where {:id id})))

(defn insertLine [params]
  (jdbc/insert! mysql-db :publiclines params))

(defn total-time-func [start-time-hours start-time-min end-time-hours end-time-min]
  (int (java-time/time-between
        (java-time/local-time start-time-hours start-time-min)
        (java-time/local-time end-time-hours end-time-min) :hours)))

(defn if-negative-time [t]
  (if (neg-int? t)
    (+ t 24)
    t))

; clojure.java-time bolje

;(defn tim-w [start-time end-time]
;  (t/minus (t/local-time end-time) (t/local-time start-time)))


;(require 'clj-time.jdbc)

;(t/local-time 10 30)
;(defn tim-w-end [start-hour-time start-min-time end-hour-time end-min-time]
;  (t/minus (t/local-time end-hour-time end-min-time) 
;     (t/local-time start-hour-time start-min-time)))

;(tim-w-end 10 10 20 20)
(def first-time
  (java-time/local-time 10 30))

(def e-time
  (java-time/local-time 11 15))

(java-time/time-between first-time e-time :minutes)

(total-time-func 10 30 11 30)
(total-time-func 10 30 00 30)

(if-negative-time -1)

(if-negative-time (total-time-func 6 30 00 30))

(java-time/minutes 60)

(java-time/sql-time 1 30)










