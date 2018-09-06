package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
* The Login Step Definition runs the BDD automation framework that 
* will automate the scenarios written in feature file 
* related to Food Court Website
* @author  Rishabh
*/
public class LoginStepDefinition 
{

	WebDriver driver;

	LoginPage objLogin;
	HomePage objHome;
	ScheduleTabPage objSchedule;
	Utility objUtility;
	AcceptInvitePage objAcceptInvite;
	UserAccountPage objUserAccount;
	
	
	@Before
    public void initializeTest()
	
	{
		objUtility = new Utility(driver);
		
		driver = objUtility.getChromeDriver();
	
		objUtility.setPropertyFiles();
    }
 
	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable 
	
	{
		//Hitting URL	
		String mainURL = objUtility.getPropTestcase().getProperty("mainURL");
		driver.get(mainURL);

		//Verifying Login Page	
	    objLogin = new LoginPage(driver);
		Assert.assertTrue("The Login page could not be verified",objLogin.verifyLoginFoodCourtPage("Food Court"));
	}

	@When("^Admin logs in with credentials$")
	public void admin_logs_in_with_credentials() 
	{
		//Admin Logging in
		 String adminLogin = objUtility.getPropTestcase().getProperty("adminLogin");
		 String adminPassword = objUtility.getPropTestcase().getProperty("adminPassword");
		 objLogin.loginFoodCourt(adminLogin,adminPassword);
		
	}

	@Then("^Admin is on home page$")
	public void admin_is_on_home_page() throws InterruptedException 
	{
		// Home Page is verified
		 objHome = new HomePage(driver);
		 Assert.assertTrue("The Home page could not be verified",objHome.verifyHomePage("Dashboard"));
		
	}

	@Then("^Admin navigates to schedule tab$")
	public void admin_navigates_to_schedule_tab() throws InterruptedException 
	{
		//Admin goes to schedule tab which is then verified 
		 objHome.ClickScheduleTab();
		 objSchedule = new ScheduleTabPage(driver);
		 Assert.assertTrue("The Scheduled Tab page could not be verified",objSchedule.VerifyScheduleTabPage("Add New Employee"));
	}

	@Then("^Admin Adds New Employee$")
	public void admin_Adds_New_Employee() throws Throwable
	
	{
		
		//New Random Email is created
		String emailHead = objUtility.getPropTestcase().getProperty("emailHead");
	    String emailType = objUtility.getPropTestcase().getProperty("emailType");
	    
	    //fetching and updating the auto increment number used for email id
	    int count = objUtility.getFileData();
		count++;
		String input=String.valueOf(count);
		objUtility.writeFile(input);
	    
	    String email = emailHead+"+"+input+"@"+emailType;
	    System.out.println("email "+email);
	    objUtility.setEmail(email);
	    String firstName =objUtility.getPropTestcase().getProperty("firstName");
	    String lastName=objUtility.getPropTestcase().getProperty("lastName");
	    String mobile=objUtility.getPropTestcase().getProperty("mobile");
	    
	   
	  //Admin adds New employee
	    objSchedule.AddNewEmployee(firstName,lastName,email, mobile);
	    Assert.assertTrue("The User added could not be verified",objSchedule.VerifyUserAdded(firstName + " "+lastName));
	  //Using sleep because sometimes it is taking time for the email to be received
	    Thread.sleep(5000);
	    
	}

	@Then("^User email is check for invite$")
	public void user_email_is_check_for_invite() throws Throwable
	
	{
		//The invite sent to user is fetched and loaded
		String email=objUtility.getEmail();
		System.out.println("email "+email);
		String emailPassword=objUtility.getPropTestcase().getProperty("emailPassword");
		String inviteURL = objUtility.fetchInviteURL(email,emailPassword,"Setup your Deputy account");	    
		System.out.println("inviteURL "+inviteURL);
		driver.close();
		driver = objUtility.getChromeDriver();
		
		driver.get(inviteURL);
	}

	@Then("^User signs up as employee$")
	public void user_signs_up_as_employee() throws Throwable
	{
		
		
		objAcceptInvite = new AcceptInvitePage(driver);
		String firstName =objUtility.getPropTestcase().getProperty("firstName");
		String email=objUtility.getEmail();
		//The invite page is verified with Title and First Name
		Assert.assertTrue("The User added could not be verified",objAcceptInvite.verifyUserAcceptInvitePage("You've been asked to join Food Court",firstName));
		
		//user account is created
		String userAccountPassword=objUtility.getPropTestcase().getProperty("userAccountPassword");
		objAcceptInvite.createUserAccount(userAccountPassword);
		
		//Employee Page is verified with email id
		objUserAccount= new UserAccountPage(driver);
		objUserAccount.verifyUserIsCreated(email);
	}

	
	
	
	@After
    public void AfterTest(Scenario scenario)
	{
		if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            	objUtility.takeScreenShot(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
            }
		driver.quit();
    }

	
	
	
	
	
	
	
	
}
