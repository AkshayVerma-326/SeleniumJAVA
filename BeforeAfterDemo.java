package TestingDemos;

import org.testng.ITestResult;
import org.testng.annotations.*;

public class BeforeAfterDemo {

    @BeforeTest
    public void method5()
    {
        System.out.println("Before Test");
    }

    @AfterTest
    public void method6()
    {
        System.out.println("After Test");
    }

    @BeforeClass
    public void method3()
    {
        System.out.println("Before Class");
    }
    @AfterClass
    public void method4()
    {
        System.out.println("After class");
    }



    @BeforeMethod
    public void method1()
    {
        System.out.println("Before Method Executed");
    }
    @Test
    public void test1()
    {
        System.out.println("Test 1 executed");
    }
    @Test
    public void test2()
    {
        System.out.println("Test 2 executed");
    }
    @AfterMethod
    public void method2(ITestResult result)
    {
        System.out.println(result.getStatus());
        System.out.println("After Method Executed");
    }

}
