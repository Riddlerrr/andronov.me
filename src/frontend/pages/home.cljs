(ns frontend.pages.home)

(defn AvatarBlock []
  [:div.ui.medium.rounded.left.floated.image
   [:img {:src "/images/sergey.jpg"}]])

(defn AboutMeBlock []
  [:<>
   [:h2 "Sergey Andronov, Ruby on Rails developer"]
   (AvatarBlock)
   [:p "I am a full stack developer with 7+ years of "
    [:mark "Ruby on Rails"]
    " experience in commercial projects."]
   [:p "Last few years I also work with "
    [:mark "Clojure"]
    " and "
    [:mark "ClojureScript"]
    ". BTW this site works on "
    [:mark "Clojure + ClojureScript"]
    " stack and it "
    [:a {:href   "https://github.com/Riddlerrr/personal-page"
         :target "_blank"}
     "open-source"]
    "."]
   [:p "I am living in Russia, "
    [:a {:href "https://en.wikipedia.org/wiki/Arzamas"} "Arzamas"]
    " and work remotely."]])

(defn ContactsBlock []
  [:div.contacts
   [:h3 "My contacts:"]
   [:a {:href "https://www.linkedin.com/in/sergey-andronov-806586b0/"}
    "LinkedIn"]
   ", "
   [:a {:href "https://t.me/Riddlerrr"}
    "Telegram"]])

(defn page-content []
  [:<>
   (AboutMeBlock)
   (ContactsBlock)])
