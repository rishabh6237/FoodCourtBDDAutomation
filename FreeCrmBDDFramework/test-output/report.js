$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Feature/FCRegisterUser.feature");
formatter.feature({
  "line": 1,
  "name": "User is registered as an employee",
  "description": "",
  "id": "user-is-registered-as-an-employee",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5959741661,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "User Registration Scenario",
  "description": "",
  "id": "user-is-registered-as-an-employee;user-registration-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin logs in with credentials",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Admin is on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Admin navigates to schedule tab",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Admin Adds New Employee",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User email is check for invite",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "User signs up as employee",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.admin_is_on_login_page()"
});
formatter.result({
  "duration": 7881848587,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.admin_logs_in_with_credentials()"
});
formatter.result({
  "duration": 11316533874,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.admin_is_on_home_page()"
});
formatter.result({
  "duration": 113492058,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.admin_navigates_to_schedule_tab()"
});
formatter.result({
  "duration": 7981665199,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.admin_Adds_New_Employee()"
});
formatter.result({
  "duration": 15530251828,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_email_is_check_for_invite()"
});
formatter.result({
  "duration": 13747711015,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_signs_up_as_employee()"
});
formatter.result({
  "duration": 18037417057,
  "status": "passed"
});
formatter.after({
  "duration": 738786576,
  "status": "passed"
});
});