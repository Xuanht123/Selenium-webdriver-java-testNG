package javaBasic;

public class Topic_01_System_Properties {

	public static void main(String[] args) {
		String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.out.println(projectPath + "\\browserDrivers\\chromedriver.exe");

		//F:\02. Selenium WebDriver\\browserDrivers\\chromedriver.exe
		//F:\02. Selenium WebDriver\browserDrivers\chromedriver.exe
	}

}
