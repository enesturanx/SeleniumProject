package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.ClassOrderer;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


@Order(1)
public class LoginTest extends BaseTest {
    @Test
    @Order(1)
    public void loginTest(){
        LoginPage LoginPage= new LoginPage();
        LoginPage.Login();
    }
}
