(ns drive-time.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [drive-time.controller.controller :as controller]
            [drive-time.domain.driver :as driver]
            [ring.util.response :as resp]))

(defroutes public-routes
  (GET "/" [] (controller/home))
  (GET "/drivers" [] (controller/drivers-page))
  (GET "/add-driver" [] (controller/add-driver-page))
  (POST "/add-driver/insertDriver" [& params]
    (do (driver/insertDriver params)
        (resp/redirect "/drivers"))))

(defroutes protected-routes)

(defroutes app-routes
  public-routes
  protected-routes
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
