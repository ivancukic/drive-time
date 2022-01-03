(ns drive-time.controller.controller
  (:require [clostache.parser :as clostache]
            [drive-time.entity.driver :as driver-entity]
            [drive-time.entity.line :as line-entity]))


(defn read-template [template-name]
  (slurp (clojure.java.io/resource
          (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn home []
  (render-template "homepage" {}))

; Drivers start here

(defn drivers-page []
  (render-template "drivers-page" {:drivers (driver-entity/allDrivers)}))

(defn add-driver-page []
  (render-template "add-driver" {}))

(defn update-driver-page [id]
  (render-template "update-driver" {:drivers (driver-entity/get id)}))

; Drivers end here
; Lines start here

(defn lines-page []
  (render-template "lines-page" {:publiclines (line-entity/allLines)}))

(defn add-line-page []
  (render-template "add-line" {}))

(defn update-line-page [id]
  (render-template "update-line" {:publiclines (line-entity/get id)}))

; Lines end here
; Shifts start here

(defn shifts-table []
  (render-template "shifts-table" {:publiclines (line-entity/allLines)
                                   :drivers (driver-entity/allDrivers)}))

(defn shift-planning [lineId]
  (render-template "shift-planning" {:publiclines (line-entity/get lineId)
                                     :drivers (driver-entity/allDrivers)}))

; Shifts end here
