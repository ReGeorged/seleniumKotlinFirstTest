package com.facebook

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.*

class MyFirstTest{
    private var driver:WebDriver?=null

    @BeforeClass
    fun createDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/kotlin/com/facebook/drivers/chromedriver.exe")
        driver = ChromeDriver()
    }

    @AfterClass
    fun tearDownDriver(){
        driver!!.quit()
    }

    @Test
    fun openWebPage(){

        val url = "https://www.facebook.com/"
        driver!!.get(url)
        Assert.assertEquals(driver!!.currentUrl, url, "webpage url did not match expected value")

        val registerButton = "#email"
        val registerButtonInteract: WebElement = driver!!.findElement(By.cssSelector(registerButton))
        Assert.assertTrue(registerButtonInteract.isDisplayed, "element was not displayed")

        val underLogoText = "._8eso"
        val underLogoTextInteract: WebElement = driver!!.findElement(By.cssSelector(underLogoText))
        val expectedUnderLogoText = "Connect with friends and the world around you on Facebook."
        Assert.assertEquals(underLogoTextInteract.text, expectedUnderLogoText, "The text did not match")


    }
}