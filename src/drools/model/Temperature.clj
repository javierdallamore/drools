(ns drools.model.Temperature
  (:gen-class
   :name "drools.model.Temperature"
   :init init
 
   ;; Define the method `getValue`
   ;; which will be accessible to Java
   :methods [[getValue [] double]]
 
   ;; The double brackets indicate a default
   ;; (parameterless) constructor
   :constructors {[double] []}
 
   ;; Store instance variables in
   ;; the state variable
   :state state))
 
;; Constructor (accepts a double `value`)
(defn -init [value]
 
  ;; we are actually going to store reference to the
  ;; value as a key-value pair in the variable `state`
  [[] (ref {:value value})])
 
;; Get the value of the Temperature object
;; (e.g. temperature in Fahrenheit)
(defn -getValue [this]
 
  ;; The get function allows us to pull the
  ;; key `value` from the state variable
  (get @(.state this) :value))
