package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
@Test(priority = 1)
public void createUserTest() {
	
	System.out.println("user created");
    }

@Test (priority = 2)
public void modifyUserTest( ) {
	System.out.println("user modified");
}

@Test (priority = 3 ,dependsOnMethods = "createUserTest")
public void deleteUserTest() {
	System.out.println("user deleted");
}



}
