(ns drools.rules.RuleRunnerTest
  (:use clojure.test
        drools.rules.RuleRunner))

(deftest a-test
  (testing (app-start)
    (is (= 0 1))))
