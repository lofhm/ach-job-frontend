(ns ach-job-frontend.app
  (:use [noir.core :only [defpage defpartial]])
  (:use [hiccup.page-helpers :only [include-css html5]])
  (:require [clojure.java.jdbc :as jdbc])
  (:use (korma db core))
  )


; DATA ***********************************************************************

(defdb jobs-db (sqlite3 {:db "ach_jobs_7-may-2012.db"}))

(defentity jobs
    (pk :jobID))


; TEMPLATES ******************************************************************

(defpartial layout [& content]
            (html5
              [:head
               [:title "ACH Job Archive"]
               (include-css "/css/bootstrap.css")]
              [:body
               [:div#wrapper
                content]]))

(defpartial job-data [{:keys [jobTitle organization country expiryDate]}]
    [:tr
        [:td expiryDate]
        [:td jobTitle]
        [:td organization]
        [:td country]])

(defpartial jobs-table [data]
    [:table.table.table-striped.table-condensed.table-bordered 
        [:tbody 
            (map job-data data)]])



; ROUTES *********************************************************************

(defpage "/" []
         (layout
             (jobs-table
                 (select jobs))))

; (defpage "/" []
;          (layout
;              [:h1 "sup"]))