package toolsandtaverns

import com.facebook.pages.NameGeneratorPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class NameGeneratorTests {

    private var driver: WebDriver?=null
    private var NameGeneratorPage: NameGeneratorPage?=null

    @BeforeClass
    fun setupDriverAndPages(){
        System.setProperty("webdriver.chrome.driver","src/main/kotlin/com/facebook/drivers/chromedriver.exe")
        driver = ChromeDriver()
        NameGeneratorPage = NameGeneratorPage(driver!!)
    }
    @AfterTest
    fun tearDownDriver(){
        driver!!.quit()
    }

    @Test
    fun generateNameDisplaysText(){


        val expectedNumberOfNames = 10

        // go to the website and verify the title
        driver!!.get("https://toolsandtaverns.com/nameGenerator")
        var titleText =NameGeneratorPage!!.title!!.text
        Assert.assertEquals(titleText,"Name Generator", "Title name did not  match")

        // Select values in dropdowns
        NameGeneratorPage!!.selectGender("Female")
        NameGeneratorPage!!.selectRace("Elf")

        //save the list of names check their amount
        NameGeneratorPage!!.generateButton!!.click()
       Thread.sleep(4000L)
        val firstListOfNames:List<String> = NameGeneratorPage!!.getGeneratedNames()
        Assert.assertEquals(firstListOfNames.size,expectedNumberOfNames, "not correct number of names ")

        //save the second list of names check their amount
        NameGeneratorPage!!.generateButton!!.click()
       Thread.sleep(4000L)
        val secondListOfNames:List<String> = NameGeneratorPage!!.getGeneratedNames()
        Assert.assertEquals(secondListOfNames.size,expectedNumberOfNames, "not correct number of names on second generation ")

       // compare if first and second list match
        Assert.assertFalse(firstListOfNames.any{ name -> secondListOfNames.contains(name)}, "error there was a matching name. \n firstlist = ${firstListOfNames}\n second list = ${secondListOfNames}")




    }


}