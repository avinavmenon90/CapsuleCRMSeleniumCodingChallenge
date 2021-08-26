$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Avinav/eclipse-workspace/CucumberBDDFramework/src/main/java/Feature/tagging.feature");
formatter.feature({
  "line": 2,
  "name": "AutomationTest Page Testing",
  "description": "",
  "id": "automationtest-page-testing",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@FunctionalTest"
    }
  ]
});
formatter.scenario({
  "line": 13,
  "name": "Search for a product",
  "description": "",
  "id": "automationtest-page-testing;search-for-a-product",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "This is a Search for a product test",
  "keyword": "Given "
});
formatter.match({
  "location": "TaggingStepDefinition.this_is_a_Search_for_a_product_test()"
});
formatter.result({
  "status": "skipped"
});
});