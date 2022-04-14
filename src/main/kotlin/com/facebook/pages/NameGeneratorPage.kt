package com.facebook.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select

class NameGeneratorPage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver,this)
    }

    @FindBy(css = ".title > h2" )
    var title: WebElement?= null

    @FindBy(css = ".gender-select" )
    var genderDropDown: WebElement?= null

    @FindBy(css = ".race-select" )
    var raceDropDown: WebElement?= null

    @FindBy(css = ".button-generate" )
    var generateButton: WebElement?= null

    @FindBy(css = ".name > span")
    var nameTextFieldValues:MutableList<WebElement>? = null


    fun getGeneratedNames():List<String>{
        return nameTextFieldValues!!.map{element -> element.text}
    }


    fun selectGender(value:String){
        Select(genderDropDown!!).selectByValue(value)
    }

    fun selectRace(value:String){
        Select(raceDropDown!!).selectByValue(value)
    }


}