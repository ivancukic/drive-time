(ns drive-time.controller.controller
  (:require [clostache.parser :as clostache]
            [drive-time.domain.driver :as driver-domain]))


(defn read-template [template-name]
  (slurp (clojure.java.io/resource
          (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn home []
  (render-template "homepage" {}))

; Drivers start here

(defn drivers-page []
  (render-template "drivers-page" {:drivers (driver-domain/allDrivers)}))

(defn add-driver-page []
  (render-template "add-driver" {}))

(defn update-driver-page [id]
  (render-template "update-driver" {:drivers (driver-domain/get id)}))

; Drivers end here