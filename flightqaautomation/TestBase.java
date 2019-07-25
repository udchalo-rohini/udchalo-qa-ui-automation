/**
 * This is base class for all the test scripts.
 * This class contains methods to carry out the initial setup
 * before any test case execution.
 * @author Rohini Kulkarni
 * @version 1.0
 * @since 2019-07-25
 *
 */
public class TestBase {
	
	
	public void initilize_Properties_And_Web_Environment(){
		this.initilize_Properties();
	}
	

	public void tearDown_Web_Environment(){
		
		webDriver.quit();
		
	}
	
	public  WebDriver getDriver(){
		
		return webDriver;
	}
	
	
	public Properties getObjConfig(){
		
		return objConfig;
	}
	
	public WrapperFunctions getObjWrapperFunctions(){
		
		return objWrapperFunctions;
	}	
	
	
	public void initilize_Properties(){
		try {
			
			objConfig=new Properties();
			objFIS=new FileInputStream(System.getProperty("user.dir")+"/test/configuration/config.properties");
			objConfig.load(objFIS);
			//this.logReporter("Property file: config.properties loaded ",true);
			
		} catch (Exception e) {

			//this.logReporter("Property file: config.properties could not be initialized.", false);
			e.printStackTrace();
		
		}

	
	
}
