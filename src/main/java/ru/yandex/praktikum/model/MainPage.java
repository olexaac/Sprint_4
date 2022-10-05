package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final static By SEARCH_BLOCK_ANSWER = By.className("accordion");
    private final static By SEARCH_BLOCK_CREATE_ORDER = By.className("Home_FinishButton__1_cWm");
    private final static By CLICK_HEADER_BUTTON_NEW_ORDER = By.xpath("//div[@class=\"Header_Nav__AGCXC\"]/button[@class=\"Button_Button__ra12g\"]");
    private final static By CLICK_MAIN_PAGE_BUTTON_NEW_ORDER = By.xpath("//div[@class=\"Home_FinishButton__1_cWm\"]/button[contains(text(), \"Заказать\")]");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void viewAccordion() {
        WebElement element = driver.findElement(SEARCH_BLOCK_ANSWER); //Найти блок со списком вопросов
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); //Скролл до блока с вопросами
    }

    public void viewButtonOrder() {
        WebElement element = driver.findElement(SEARCH_BLOCK_CREATE_ORDER); //Найти блок с описанием и кнопкой заказа
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void orderInHeader() {
        driver.findElement(CLICK_HEADER_BUTTON_NEW_ORDER).click(); //Нажатие на кнопку заказа в шапке
    }

    public void orderInMain() {
        driver.findElement(CLICK_MAIN_PAGE_BUTTON_NEW_ORDER).click(); //Нажатие на кнопку заказа на главной странице
    }
}
