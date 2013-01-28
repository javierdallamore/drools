(ns drools.rules.RuleRunner
  (:use drools.model.Temperature))

;; Construct a Knowledge Session
;; from the 'WeatherRules.drl' definition.
(defn build-knowledge-session []
 
  ;; Create the KnowledgeBuilder object
  (def knowledge-builder
    (org.drools.builder.KnowledgeBuilderFactory/newKnowledgeBuilder))
 
  ;; Adding the Weather Rules definition
  ;; to the KnowledgeBuilder
  (.add knowledge-builder
    (org.drools.io.ResourceFactory/newClassPathResource
       "WeatherRules.drl")
     org.drools.builder.ResourceType/DRL)
 
  ;; Creating the KnowledgeBase
  (def knowledge-base
    (org.drools.KnowledgeBaseFactory/newKnowledgeBase))
 
  ;; Adding Knowledge Packages to the KnowledgeBase
  (.addKnowledgePackages knowledge-base
    (. knowledge-builder getKnowledgePackages))
 
  ;; Create a Stateful Knowledge Session
  ;; and return it to the calling function
  (. knowledge-base newStatefulKnowledgeSession))

;; Start the Application
(defn app-start []
 
    ;; Create the Knowledge Session
    (def knowledge-session (build-knowledge-session))
 
    ;; Create a Temperature fact
    (def shouldBeTooHot
      (drools.model.Temperature. 100))
 
    ;; Create another Temperature fact
    (def shouldBeTooCold
      (drools.model.Temperature. 20))
 
    ;; Insert the facts & fire all rules
    (doto knowledge-session
      (.insert shouldBeTooHot)
      (.insert shouldBeTooCold)
      (.fireAllRules)))
