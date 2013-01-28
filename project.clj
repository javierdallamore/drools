(defproject drools "0.1.0-SNAPSHOT"
  :description "drools and clojure project"
  :url "http://github.com/javierdallamore/drools"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [log4j/log4j "1.2.16"]
                 [org.drools/drools-core "5.5.0.Final"]
                 [org.drools/drools-compiler "5.5.0.Final"]
                 [org.drools/knowledge-api "5.5.0.Final"]
                 [org.drools/drools-decisiontables "5.5.0.Final"]
                 [com.sun.xml.bind/jaxb-xjc "2.2-EA"]]
  :main drools.rules.RuleRunner/app-start)
