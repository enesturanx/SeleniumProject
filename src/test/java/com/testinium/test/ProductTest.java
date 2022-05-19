package com.testinium.test;
import com.testinium.driver.BaseTest;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.jupiter.api.*;
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@Order(2)
public class ProductTest extends BaseTest {
    @Test
    @Order(5)
    public void sepetVeOdemeTest(){
        LoginPage LoginPage = new LoginPage();
        LoginPage.Login();
        ProductPage productPage = new ProductPage();
        productPage.sepetimVeOdeme();
    }

    @Test
    @Order(4)
    public void favorilerimTest(){
        ProductPage productPage = new ProductPage();
        productPage.favorilerim();
    }


    @Test
    @Order(3)
    public void sepeteEkleTest(){
        ProductPage productPage = new ProductPage();
        productPage.sepeteEkle();
    }

    @Test
    @Order(2)
    public void puanCatalogTest(){
        //LoginPage LoginPage = new LoginPage();
        //LoginPage.Login();
        ProductPage productPage = new ProductPage();
        productPage.puanKatalog();
    }

    @Test
    @Order(1)
    public void scrollAndFavTest(){
        LoginPage LoginPage = new LoginPage();
        LoginPage.Login();
        ProductPage productPage = new ProductPage();
        productPage.scrollAndFav();
    }

}

