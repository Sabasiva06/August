$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Login.feature");
formatter.feature({
  "name": "Verifying Login function of facebook application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verifying login with invalid username and invalid password for facebook application",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on facebook page",
  "keyword": "Given "
});
formatter.step({
  "name": "user should enter \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user should click login button",
  "keyword": "And "
});
formatter.step({
  "name": "user should validate home page is present or not",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "hijavaa",
        "WelcomeJava"
      ]
    },
    {
      "cells": [
        "hiSelenium",
        "WelcomeSelenium"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verifying login with invalid username and invalid password for facebook application",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on facebook page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.user_is_on_facebook_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should enter \"hijavaa\" and \"WelcomeJava\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.user_should_enter_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should click login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.user_should_click_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should validate home page is present or not",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.user_should_validate_home_page_is_present_or_not()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verifying login with invalid username and invalid password for facebook application",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on facebook page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.user_is_on_facebook_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should enter \"hiSelenium\" and \"WelcomeSelenium\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.user_should_enter_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should click login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.user_should_click_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should validate home page is present or not",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.user_should_validate_home_page_is_present_or_not()"
});
formatter.result({
  "status": "passed"
});
});