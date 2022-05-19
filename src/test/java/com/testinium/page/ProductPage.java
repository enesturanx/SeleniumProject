package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import java.util.Random;

public class ProductPage {
    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);
    static String attribute;
    public ProductPage(){
        methods=new Methods();


    }

    public void scrollAndFav(){
        methods.sendKeys(By.xpath("//div[@id='search']/input"),"oyuncak");
        methods.waitBySecond(1);
        methods.click(By.xpath("//span[@class='common-sprite button-search']"));
        methods.waitBySecond(1);
        methods.scrollWithAction(By.xpath("//div[@class='product-list']/div[7]"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//div[@class='product-cr'][5]//a[@class='add-to-favorites']"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//div[@class='product-cr'][6]//a[@class='add-to-favorites']"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//div[@class='product-cr'][7]//a[@class='add-to-favorites']"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//div[@class='product-cr'][8]//a[@class='add-to-favorites']"));
        methods.waitBySecond(3);
        String[] array= new String[4];
        String[] array1= {"display: none;","display: none;","display: none;","display: none;"};
        attribute= methods.getAttribute(By.xpath("//div[@class='product-cr'][7]"),"id");
        array[0] =methods.getAttribute(By.xpath("//div[@class='product-cr'][5]//a[@class='add-to-favorites']"),"style");
        array[1] =methods.getAttribute(By.xpath("//div[@class='product-cr'][6]//a[@class='add-to-favorites']"),"style");
        array[2] =methods.getAttribute(By.xpath("//div[@class='product-cr'][7]//a[@class='add-to-favorites']"),"style");
        array[3] =methods.getAttribute(By.xpath("//div[@class='product-cr'][8]//a[@class='add-to-favorites']"),"style");
        Assertions.assertArrayEquals(array1,array,"Favori ekleme basarisiz");
        methods.click(By.cssSelector(".logo-text>a"));
        methods.waitBySecond(1);
        System.out.println(attribute);
    }

    public void puanKatalog(){

        methods.click(By.xpath("//div[@class='lvl1catalog']/a"));
        methods.waitBySecond(1);
        methods.scrollWithAction(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySecond(1);
        methods.selectByText(By.xpath("//select[@onchange]"),"Yüksek Oylama");
        methods.waitBySecond(1);

    }

    public void sepeteEkle(){
        Random rand = new Random();
        int upper= 15;
        methods.click(By.xpath("//div[@class='lvl2 js-bookCr']//li[@class='has-open-menu'][3]/span"));
        methods.waitBySecond(1);
        //methods.click(By.xpath("//div[@class='lvl2 js-bookCr']//li[@class='has-open-menu'][3]//a[@href='kategori/kitap-hobi/1_212.html']"));
        methods.click(By.xpath("//a[normalize-space()='Hobi']"));
        methods.waitBySecond(1);
        int int_random = rand.nextInt(upper);
        methods.click(By.xpath("//li[@class='mg-b-10']["+int_random+"]//a//img"));
        methods.waitBySecond(1);
        methods.scrollWithAction(By.id("button-cart"));
        methods.waitBySecond(1);
        methods.click(By.id("button-cart"));
    }

    public void favorilerim(){
        methods.scrollWithAction(By.xpath("//div[@class='menu top my-list']"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//div[@class='menu top my-list']//div//a"));
        methods.waitBySecond(1);
        methods.scrollWithAction(By.xpath("//div[@class='box-content']//li[14]"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//div[@id='"+attribute+"']//a[@data-title='Favorilerimden Sil']"));
        methods.waitBySecond(1);

    }
    public void sepetimVeOdeme(){
        methods.click(By.id("sprite-cart-icon"));
        methods.waitBySecond(1);
        methods.click(By.id("js-cart"));
        methods.waitBySecond(1);
        methods.clear(By.xpath("//input[@name='quantity']"));
        methods.waitBySecond(1);
        methods.sendKeys(By.xpath("//input[@name='quantity']"),"2");
        methods.waitBySecond(1);
        methods.click(By.cssSelector(".to-wishlist>a"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//a[@href='#tab-shipping-new-adress']"));
        methods.waitBySecond(2);
        methods.sendKeys(By.xpath("//input[@name='firstname_companyname']"),"Enes");
        methods.sendKeys(By.xpath("//input[@name='lastname_title']"),"Turan");
        methods.selectByText(By.id("address-zone-id"),"Manisa");
        methods.waitBySecond(2);
        methods.selectByText(By.id("address-county-id"),"YUNUSEMRE");
        methods.sendKeys(By.xpath("//input[@name='district']"),"Yeni Mahalle");
        methods.sendKeys(By.xpath("//textarea[@id='address-address-text']"),"4754 sokak No 13/1");
        methods.sendKeys(By.xpath("//input[@name='postcode']"),"45000");
        methods.sendKeys(By.xpath("//input[@name='mobile_telephone']"),"5308673286");
        methods.sendKeys(By.xpath("//input[@name='tax_id']"),"30377134930");
        methods.waitBySecond(1);
        methods.click(By.xpath("//button[@class='button']"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySecond(3);
        methods.sendKeys(By.xpath("//input[@name='credit_card_owner']"),"Enes Turan");
        methods.sendKeys(By.xpath("//input[@name='credit_card_number_1']"),"4545");
        methods.sendKeys(By.xpath("//input[@name='credit_card_number_2']"),"4545");
        methods.sendKeys(By.xpath("//input[@name='credit_card_number_3']"),"4545");
        methods.sendKeys(By.xpath("//input[@name='credit_card_number_4']"),"4545");
        methods.selectByText(By.id("credit-card-expire-date-month"),"01");
        methods.selectByText(By.id("credit-card-expire-date-year"),"2025");
        methods.sendKeys(By.xpath("//input[@name='credit_card_security_code']"),"345");
        methods.waitBySecond(2);
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySecond(1);
        //Assertions.assertFalse(methods.isElementVisible(By.xpath("//span[@class='error']")),"Kart numarasi gecersiz. Kontrol ediniz!");
        methods.waitBySecond(1);
        methods.click(By.className("checkout-logo"));
        methods.waitBySecond(2);
        methods.cikis();
        methods.waitBySecond(3);
    }

}
