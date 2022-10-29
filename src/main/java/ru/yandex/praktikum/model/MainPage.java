package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By SEARCH_BLOCK_ANSWER = By.className("accordion");
    private final By SEARCH_ANSWER_ONE = By.id("accordion__heading-0");
    private final By SEARCH_ANSWER_TWO = By.id("accordion__heading-1");
    private final By SEARCH_ANSWER_THREE = By.id("accordion__heading-2");
    private final By SEARCH_ANSWER_FOUR = By.id("accordion__heading-3");
    private final By SEARCH_ANSWER_FIVE = By.id("accordion__heading-4");
    private final By SEARCH_ANSWER_SIX = By.id("accordion__heading-5");
    private final By SEARCH_ANSWER_SEVEN = By.id("accordion__heading-6");
    private final By SEARCH_ANSWER_EIGHT = By.id("accordion__heading-7");
    private final By SEARCH_BLOCK_CREATE_ORDER = By.className("Home_FinishButton__1_cWm");
    private final By CLICK_HEADER_BUTTON_NEW_ORDER = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private final By CLICK_MAIN_PAGE_BUTTON_NEW_ORDER = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[contains(text(), 'Заказать')]");
    private final By CLICK_QUESTION_ONE = By.xpath("//div[@id='accordion__panel-0']/p");
    private final By CLICK_QUESTION_TWO = By.xpath("//div[@id='accordion__panel-1']/p");
    private final By CLICK_QUESTION_THREE = By.xpath("//div[@id='accordion__panel-2']/p");
    private final By CLICK_QUESTION_FOUR = By.xpath("//div[@id='accordion__panel-3']/p");
    private final By CLICK_QUESTION_FIVE = By.xpath("//div[@id='accordion__panel-4']/p");
    private final By CLICK_QUESTION_SIX = By.xpath("//div[@id='accordion__panel-5']/p");
    private final By CLICK_QUESTION_SEVEN = By.xpath("//div[@id='accordion__panel-6']/p");
    private final By CLICK_QUESTION_EIGHT = By.xpath("//div[@id='accordion__panel-7']/p");

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

    public void clickQuestionNumbOne() {
        driver.findElement(SEARCH_ANSWER_ONE).click(); //Ответ на первый вопрос
    }

    public void clickQuestionNumbTwo() {
        driver.findElement(SEARCH_ANSWER_TWO).click();
    }

    public void clickQuestionNumbThree() {
        driver.findElement(SEARCH_ANSWER_THREE).click();
    }

    public void clickQuestionNumbFour() {
        driver.findElement(SEARCH_ANSWER_FOUR).click();
    }

    public void clickQuestionNumbFive() {
        driver.findElement(SEARCH_ANSWER_FIVE).click();
    }

    public void clickQuestionNumbSix() {
        driver.findElement(SEARCH_ANSWER_SIX).click();
    }

    public void clickQuestionNumbSeven() {
        driver.findElement(SEARCH_ANSWER_SEVEN).click();
    }

    public void clickQuestionNumbEight() {
        driver.findElement(SEARCH_ANSWER_EIGHT).click();
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

    public Object viewAnswerQuestionOne() {
        return driver.findElement(CLICK_QUESTION_ONE).getAttribute("innerHTML");
    }

    public Object viewAnswerQuestionTwo() {
        return driver.findElement(CLICK_QUESTION_TWO).getAttribute("innerHTML");
    }

    public Object viewAnswerQuestionThree() {
        return driver.findElement(CLICK_QUESTION_THREE).getAttribute("innerHTML");
    }

    public Object viewAnswerQuestionFour() {
        return driver.findElement(CLICK_QUESTION_FOUR).getAttribute("innerHTML");
    }

    public Object viewAnswerQuestionFive() {
        return driver.findElement(CLICK_QUESTION_FIVE).getAttribute("innerHTML");
    }

    public Object viewAnswerQuestionSix() {
        return driver.findElement(CLICK_QUESTION_SIX).getAttribute("innerHTML");
    }
    public Object viewAnswerQuestionSeven() {
        return driver.findElement(CLICK_QUESTION_SEVEN).getAttribute("innerHTML");
    }

    public Object viewAnswerQuestionEight() {
        return driver.findElement(CLICK_QUESTION_EIGHT).getAttribute("innerHTML");
    }
}
