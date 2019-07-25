import org.testng.Assert;

public class LoginTest extends TestBase{

private LoginLogoutView objLoginLogoutView;

	
	@BeforeClass
	public void initilizeWebEnvironment(){
		objLoginLogoutView=new LoginLogoutView(this);
		this.initilize_Properties_And_Web_Environment();
	}
	
	@Test
	public TC001_LoginTest(){
		Assert.assertTrue(true);
	}
	
	
	@AfterClass
	public void tearDownEnvironment(){
		
		this.tearDown_Web_Environment();
		
	}


}
