(ns frontend.layouts.main
  (:require [cljsjs.semantic-ui-react :as ui]
            [reitit.frontend.easy :as rfe]))

(defn Header []
  [:header
   [:> ui/Menu
    {:fixed      "top"
     :borderless true}
    [:> ui/Menu.Item {:name   "Sergey Andronov"
                      :header true
                      :href   (rfe/href :homepage)}]
    [:> ui/Menu.Item {:name     "About me"
                      :href     (rfe/href :about)
                      :position "right"}]
    [:> ui/Menu.Item {:name "Resume"
                      :href (rfe/href :resume)}]]])

(defn page-content [current-page-match]
  [:div
     (Header)
     [:> ui/Container
      {:text true
       :className "main"}
      (when @current-page-match
        (let [view (:view (:data @current-page-match))]
          [view @current-page-match]))]])
