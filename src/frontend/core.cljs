(ns frontend.core
  (:require [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]
            [fipp.edn :as fedn]
            [cljsjs.semantic-ui-react :as ui]))

(defonce match (r/atom nil))

(defn home-page []
  [:div
   [:h2 "Welcome to my personal page"]])

(defn about-page []
  [:div
   [:h2 "About frontend"]])

(defn resume-page []
  [:div
   [:h2 "Resume page"]])
  
(defn header []
  [:header
   [:> ui/Menu
    {:fixed "top"
     :borderless true}
    [:> ui/Menu.Item {:name "Sergey Andronov" :header true :href (rfe/href ::homepage)}]
    [:> ui/Menu.Item {:name "About me" :key "about-me" :href (rfe/href ::about) :position "right"}]
    [:> ui/Menu.Item {:name "Resume" :key "resume" :href (rfe/href ::resume)}]]])
      
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

(def routes
  [["/"
    {:name ::homepage
     :view home-page}]

   ["/about"
    {:name ::about
     :view about-page}]
   
   ["/resume"
    {:name ::resume
     :view resume-page}]])


(defn init! []
  (rfe/start!
    (rf/router routes {:data {:coercion rss/coercion}})
    (fn [m] (reset! match m))
    {:use-fragment false})
  (r/render [current-page] (.getElementById js/document "app")))

(init!)
