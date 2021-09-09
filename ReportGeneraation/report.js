$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Login.feature");
formatter.feature({
  "name": "Getting Search Count from google",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Search count of a product from google",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on Google page",
  "keyword": "Given "
});
formatter.step({
  "name": "user enter text on search filed by given sheetname \"\u003csheetName\u003e\" and rownumber \u003crownumber\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "get the search count and add into excel",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "sheetName",
        "rownumber"
      ]
    },
    {
      "cells": [
        "Sheet1",
        "1"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search count of a product from google",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on Google page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.userIsOnGooglePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter text on search filed by given sheetname \"Sheet1\" and rownumber 1",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.userEnterTextOnSearchFiledByGivenSheetnameAndRownumber(String,Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get the search count and add into excel",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.getTheSearchCountAndAddIntoExcel()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});