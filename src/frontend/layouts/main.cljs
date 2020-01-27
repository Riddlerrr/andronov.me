(ns frontend.layouts.main
  (:require [cljsjs.semantic-ui-react :as ui]))

(defn page-content [current-page-match]
  [:<>
     [:> ui/Container
      {:text true
       :className "main"}
      (when @current-page-match
        (let [view (:view (:data @current-page-match))]
          [view @current-page-match]))]])
