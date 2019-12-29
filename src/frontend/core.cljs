(ns frontend.core
  (:require [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]
            [fipp.edn :as fedn]
            [cljsjs.semantic-ui-react :as ui]
            [frontend.pages.home :as hp]))

(defonce match (r/atom nil))

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
    [:> ui/Menu.Item {:name "About me" :href (rfe/href ::about) :position "right"}]
    [:> ui/Menu.Item {:name "Resume" :href (rfe/href ::resume)}]]])
      
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
     :view hp/page-content}]

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
