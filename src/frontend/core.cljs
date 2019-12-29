(ns frontend.core
  (:require [reagent.core :as r]
            [reitit.frontend.easy :as rfe]
            [frontend.routes :refer [router]]
            [frontend.layouts.main :as layout]))

(defonce match (r/atom nil))
    
(defn current-page []
  (layout/page-content match))

(defn init! []
  (rfe/start!
    router
    (fn [m] (reset! match m))
    {:use-fragment false})
  (r/render [current-page] (.getElementById js/document "app")))

(init!)
