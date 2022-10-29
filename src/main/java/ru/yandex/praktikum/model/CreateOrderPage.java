package ru.yandex.praktikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateOrderPage {

    private final By FILL_INPUT_NAME = By.xpath("//input[contains(@placeholder, 'Имя')]");
    private final By FILL_INPUT_SURNAME = By.xpath("//input[contains(@placeholder, 'Фамилия')]");
    private final By FILL_INPUT_ADDRESS = By.xpath("//input[contains(@placeholder, 'Адрес')]");
    private final By FILL_INPUT_METRO = By.xpath("//input[@class= 'select-search__input']");
    private final By SELECT_METRO = By.xpath("//div[@class='select-search__select']");
    private final By FILL_INPUT_PHONE = By.xpath("//input[contains(@placeholder, 'Телефон')]");
    private final By CLICK_NEXT_STEP = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By FII_INPUT_DATE = By.xpath("//input[contains(@placeholder, 'Когда')]");
    private final By SELECT_DATE = By.xpath("//div[contains(@class, 'selected react-datepicker__day--today')]");
    private final By FILL_INPUT_RENT = By.xpath("//span[@class='Dropdown-arrow']");
    private final By SELECT_RENT = By.xpath("//div[@class='Dropdown-option'][1]");
    private final By CLICK_CREATE_ORDER = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By CLICK_YES_ORDER = By.xpath("//button[contains(text(), 'Да')]");
    private final By CHECK_MESSAGE_CREATE_ORDER = By.xpath("//div[contains(text(), 'Заказ оформлен')]");


    private final WebDriver driver;
    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void nameForOrder(String firstName) {
        driver.findElement(FILL_INPUT_NAME).sendKeys(firstName); //Заполнение поля Имя.Contains использован для поиска инпута с минимальным количеством символов на случай если название будет изменено. По названию класса искать не стал, т.к. значение может оказаться динамическим и в будущем изменится
    }

    public void surnameForOrder(String lastName) {
        driver.findElement(FILL_INPUT_SURNAME).sendKeys(lastName); //Заполнение поля Фамилия
    }

    public void addressForOrder(String addressDelivery) {
        driver.findElement(FILL_INPUT_ADDRESS).sendKeys(addressDelivery); //Заполнение поля Адрес
    }

    public void metroSearchForOrder(String stationMetro) {
        driver.findElement(FILL_INPUT_METRO).sendKeys(stationMetro); //Вызываем выпадющий список со странцией метро и вводим туда значение
    }

    public void metroSelectForOrder() {
        driver.findElement(SELECT_METRO).click(); //Находим совпадения в селекте и выбираем станцию метро
    }

    public void phoneForOrder(String phoneNumber) {
        driver.findElement(FILL_INPUT_PHONE).sendKeys(phoneNumber); //Заполнение поля телефон
    }

    public void nextForOrder() {
        driver.findElement(CLICK_NEXT_STEP).click(); //Нажимаем Далее
    }

    public void dateSearchForOrder() {
        driver.findElement(FII_INPUT_DATE).click(); //Вызываем виджет календаря
    }

    public void dateSelectForOrder() {
        driver.findElement(SELECT_DATE).click(); //Выбираем дефолтную дату (сегодняшнее число)
    }

    public void rentSearchForOrder() {
        driver.findElement(FILL_INPUT_RENT).click(); //Вызываем выпадающий список со сроком аренды
    }

    public void rentSelectForOrder() {
        driver.findElement(SELECT_RENT).click(); //Выбираем срок аренды из селекта (в данном случае всегда будет выбираться первое значение из списка)
    }

    public void createButtonForOrder() {
        driver.findElement(CLICK_CREATE_ORDER).click(); //Нажимаем на кнопку заказа
    }

    public void confirmForOrder() {
        driver.findElement(CLICK_YES_ORDER).click(); //Подтверждаем заказ в окне
    }

    public boolean isMessageCreateNewOrder() {
        return driver.findElement(CHECK_MESSAGE_CREATE_ORDER).isDisplayed(); //Проверяем сообщение об успешном создании заказа
    }
}