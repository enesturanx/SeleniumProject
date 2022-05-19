package com.testinium.page;


import com.testinium.methods.Methods;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class LoginPage {
    Methods methods;
    public LoginPage(){
        methods = new Methods();
    }

    public void Login(){
        methods.click(By.xpath("//div[@class=\"menu-top-button login\"]"));
        methods.waitBySecond(1);
        methods.click(By.cssSelector(".popupCloseIcon"));
        methods.sendKeys(By.id("login-email"),"ebek145@gmail.com");
        methods.waitBySecond(1);
        methods.sendKeys(By.xpath("//input[@id='login-password']"),"testinium1548");
        methods.waitBySecond(1);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySecond(5);
        //Assert.assertTrue("login basarisiz",methods.isElementVisible(By.xpath("//div[@class='breadcrumb']")));
        Assertions.assertTrue(methods.isElementVisible(By.xpath("//div[@class='breadcrumb']")),"login basarisiz");
    }
}
