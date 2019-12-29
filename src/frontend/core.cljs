(ns frontend.core
  (:require [reagent.core :as r]
            [reitit.frontend.easy :as rfe]
            [fipp.edn :as fedn]
            [cljsjs.semantic-ui-react :as ui]
            [frontend.routes :refer [router]]))

(defonce match (r/atom nil))

(defn header []
  [:header
   [:> ui/Menu
    {:fixed "top"
     :borderless true}
    [:> ui/Menu.Item {:name "Sergey Andronov" :header true :href (rfe/href :homepage)}]
    [:> ui/Menu.Item {:name "About me" :href (rfe/href :about) :position "right"}]
    [:> ui/Menu.Item {:name "Resume" :href (rfe/href :resume)}]]])
    
(defn current-page []
  [:div
   (header)
   [:> ui/Container
    {:text true
     :className "main"}
    (when @match
      (let [view (:view (:data @match))]
        [view @match]))
    [:pre (with-out-str (fedn/pprint @match))]]])

(defn init! []
  (rfe/start!
    router
    (fn [m] (reset! match m))
    {:use-fragment false})
  (r/render [current-page] (.getElementById js/document "app")))

(init!)
