(ns frontend.routes
  (:require [reitit.frontend :as rf]
            [reitit.coercion.spec :as rss]
            [frontend.pages.home :as hp]
            [frontend.pages.about :as ap]
            [frontend.pages.resume :as rp]))

(def routes
  [["/"
    {:name :homepage
     :view hp/page-content}]

   ["/about"
    {:name :about
     :view ap/page-content}]
   
   ["/resume"
    {:name :resume
     :view rp/page-content}]])

(def router
  (rf/router routes {:data {:coercion rss/coercion}}))

(js/console.log (rf/match-by-name router ::frontend))
