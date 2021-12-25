(ns drive-time.domain.driver
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/drive-time"
               :user "root"
               :password "java"
               :zeroDateTimeBehavior "convertToNull"})

(defn allDrivers[]
  (jdbc/query mysql-db
              ["SELECT * FROM drivers d"]))

(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM drivers WHERE id = ?" id])))

(defn removeDriver [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM drivers WHERE id = ?" id]))

(defn updateDriver [id params]
  (jdbc/update! mysql-db :drivers params (sql/where {:id id})))

(defn insertDriver [params]
  (jdbc/insert! mysql-db :drivers params))

