(ns drive-time.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [drive-time.controller.controller :as controller]
            [drive-time.entity.driver :as driver]
            [drive-time.entity.line :as line]
            [ring.util.response :as resp]))

(defroutes public-routes
  (GET "/" [] (controller/home))

  (GET "/drivers" [] (controller/drivers-page))

  (GET "/add-driver" [] (controller/add-driver-page))
  (POST "/add-driver/insertDriver" [& params]
    (do (driver/insertDriver params)
        (resp/redirect "/drivers")))

  (GET "/updateDriver/:id/updateDriver" [id]
    (controller/update-driver-page id))
  (POST "/updateDriver/:id/updateDriver" [& params]
    (do (driver/updateDriver (:id params) params)
        (resp/redirect "/drivers")))

  (GET "/drivers/:id/removeDriver" [id]
    (do (driver/removeDriver id)
        (resp/redirect "/drivers")))

  ;lines
  (GET "/lines" [] (controller/lines-page))

  (GET "/add-line" [] (controller/add-line-page))
  (POST "/add-line/insertLine" [& params]
    (do (line/insertLine params)
        (line/calcTotalTime)
        (line/negative-time)
        (line/num-drivers)
        (resp/redirect "/lines")))

  (GET "/updateLine/:id/updateLine" [id]
    (controller/update-line-page id))
  (POST "/updateLine/:id/updateLine" [& params]
    (do (line/updateLine (:id params) params)
        (resp/redirect "/lines")))

  (GET "/lines/:id/removeLine" [id]
    (do (line/removeLine id)
        (resp/redirect "/lines")))

  (GET "/shiftsPlanning/:id/:num_drivers/shiftsPlanning" [id num_drivers]
    
    (if (= (Integer. num_drivers) 1)
      (controller/shift-planning-one id)
      (if (= (Integer. num_drivers) 2)
        (controller/shift-planning-two id)
          (controller/shift-planning-three id)))
    ;(controller/shift-planning id num_drivers) 
    
    ;(str "Tip je " (type num_drivers))
    ;(Integer. num_drivers)
    ;(str "Drugi tip" (type (Integer. num_drivers)))
    
    )
  (POST "/updateLine/:id/updateLine" [& params]
    (do (line/updateLine (:id params) params)
        (resp/redirect "/lines")))

  (GET "/shift-table" []
    (controller/shifts-table))

  ;(POST "/shiftsPlanning/:lineId/shiftsPlanning/" [& params]
  ;  (do (line/shiftPlanning (:lineId params) params)
  ;      (resp/redirect "/lines")))
  )

(defroutes protected-routes)

(defroutes app-routes
  public-routes
  protected-routes
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
