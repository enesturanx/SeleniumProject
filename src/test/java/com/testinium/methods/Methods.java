package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor javascriptdriver;
    public Methods(){
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        javascriptdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by){
        findElement(by).click();
    }

    public void clear(By by){
        findElement(by).clear();
    }

    public void waitBySecond(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void scrollWithAction(By by){
        Actions action =new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }
    public void cikis(){
        javascriptdriver.executeScript("document.getElementsByClassName('menu top login')[0].lastElementChild.firstElementChild.lastElementChild.lastElementChild.lastElementChild.firstElementChild.click();");
    }


    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributename){
        return findElement(by).getAttribute(attributename);

    }

}
