(ns frontend.routes
  (:require [reitit.frontend :as rf]
            [reitit.coercion.spec :as rss]
            [frontend.pages.home :as hp]))

(def routes
  [["/"
    {:name :homepage
     :view hp/page-content}]])

(def router
  (rf/router routes {:data {:coercion rss/coercion}}))
