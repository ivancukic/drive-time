(ns drive-time.entity.line
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            [java-time :as java-time]
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

(defn calcTotalTime []
  (jdbc/execute! mysql-db
                 ["UPDATE publiclines SET `total_time`= SUBTIME (end_time, start_time)"]))

(defn negative-time []
  (jdbc/execute! mysql-db
                 ["UPDATE publiclines SET total_time = IF (total_time < '00:00:00', ADDTIME(total_time, '24:00:00'), total_time)"]))

(defn num-drivers []
   (jdbc/execute! mysql-db
                  ["UPDATE publiclines SET num_drivers = IF (total_time < '08:01:00', 1, IF (total_time < '16:01:00', 2, 3))"]))

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

(defn total-time [start-time-hours start-time-min end-time-hours end-time-min]
  (if-negative-time 
   (total-time-func start-time-hours start-time-min end-time-hours end-time-min)))

(total-time 10 30 1 30)

; PRACTICE FOR TIME
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










