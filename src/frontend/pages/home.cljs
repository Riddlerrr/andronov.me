(ns frontend.pages.home)

(defn page-content []
  [:div
   [:h2 "Sergey Andronov, Ruby on Rails developer"]
   [:p "I am a full stack developer with 7+ years of " 
    [:mark "Ruby on Rails"] 
    " experience in commercial projects."]
   [:p "Last few years I also work with "
    [:mark "Clojure and ClojureScript"]
    ". BTW this site works on "
    [:mark "Clojure + ClojureScript"] 
    " stack and it "
    [:a {:href "https://github.com/Riddlerrr/personal-page" :target "_blank"}
     "open-source"]
    "."]])
