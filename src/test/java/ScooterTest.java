import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.CreateOrderPage;
import ru.yandex.praktikum.model.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScooterTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkAccordionAnswerOneExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();

        driver.findElement(By.id("accordion__heading-0")).click(); //Ответ на первый вопрос
        WebElement AnswerNumber1 = driver.findElement(By.xpath("//div[@class=\"accordion__panel\"]/p"));
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", AnswerNumber1.getAttribute("innerHTML"));
    }

    @Test
    public void checkAccordionAnswerTwoExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        driver.findElement(By.id("accordion__heading-1")).click();

        WebElement AnswerNumber2 = driver.findElement(By.xpath("//p[contains(text(), \"один самокат\")]"));
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", AnswerNumber2.getAttribute("innerHTML"));
    }

    @Test
    public void checkAccordionAnswerThreeExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        driver.findElement(By.id("accordion__heading-2")).click();

        WebElement AnswerNumber3 = driver.findElement(By.xpath("//p[contains(text(), \"Отсчёт времени\")]"));
        String text3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals(text3, AnswerNumber3.getAttribute("innerHTML"));
    }

    @Test
    public void checkAccordionAnswerFourExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        driver.findElement(By.id("accordion__heading-3")).click();

        WebElement AnswerNumber4 = driver.findElement(By.xpath("//p[contains(text(), \"начиная с завтрашнего дня\")]"));
        String text4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals(text4, AnswerNumber4.getAttribute("innerHTML"));
    }

    @Test
    public void checkAccordionAnswerFiveExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        driver.findElement(By.id("accordion__heading-4")).click();

        WebElement AnswerNumber5 = driver.findElement(By.xpath("//p[contains(text(), \"Пока что нет\")]"));
        String text5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals(text5, AnswerNumber5.getAttribute("innerHTML"));
    }

    @Test
    public void checkAccordionAnswerSixExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        driver.findElement(By.id("accordion__heading-5")).click();

        WebElement AnswerNumber6 = driver.findElement(By.xpath("//p[contains(text(), \"с полной зарядкой\")]"));
        String text6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals(text6, AnswerNumber6.getAttribute("innerHTML"));
    }

    @Test
    public void checkAccordionAnswerSevenExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        driver.findElement(By.id("accordion__heading-6")).click();

        WebElement AnswerNumber7 = driver.findElement(By.xpath("//p[contains(text(), \"Да, пока самокат не привезли\")]"));
        String text7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals(text7, AnswerNumber7.getAttribute("innerHTML"));
    }

    @Test
    public void checkAccordionAnswerEightExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        driver.findElement(By.id("accordion__heading-7")).click();

        WebElement AnswerNumber8 = driver.findElement(By.xpath("//p[contains(text(), \"Да, обязательно\")]"));
        String text8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals(text8, AnswerNumber8.getAttribute("innerHTML"));
    }

    @Test
    public void createOrderHeader() { //Создание заказа по клику на кнопку в хедере
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.orderInHeader(); //Нажатие на кнопку заказа в шапке

        CreateOrderPage createOrderPage = new CreateOrderPage(driver);
        createOrderPage.nameForOrder(); //Заполнение поля Имя.Contains использован для поиска инпута с минимальным количеством символов на случай если название будет изменено. По названию класса искать не стал, т.к. значение может оказаться динамическим и в будущем изменится
        createOrderPage.surnameForOrder(); //Заполнение поля Фамилия
        createOrderPage.addressForOrder(); //Заполнение поля Адрес
        createOrderPage.metroSearchForOrder(); //Вызываем выпадющий список со странцией метро и вводим туда значение
        createOrderPage.metroSelectForOrder(); //Находим совпадения в селекте и выбираем станцию метро
        createOrderPage.phoneForOrder(); //Заполнение поля телефон
        createOrderPage.nextForOrder(); //Нажимаем Далее
        createOrderPage.dateSearchForOrder(); //Вызываем виджет календаря
        createOrderPage.dateSelectForOrder(); //Выбираем дефолтную дату (сегодняшнее число)
        createOrderPage.rentSearchForOrder(); //Вызываем выпадающий список со сроком аренды
        createOrderPage.rentSelectForOrder(); //Выбираем срок аренды из селекта (в данном случае всегда будет выбираться первое значение из списка)
        createOrderPage.createButtonForOrder(); //Нажимаем на кнопку заказа
        createOrderPage.confirmForOrder(); //Подтверждаем заказ в окне
        assertTrue("Expected Massage Not Found", createOrderPage.isMessageCreateNewOrder()); //Проверяем сообщение об успешном создании заказа
    }

    @Test
    public void createOrderHomePage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewButtonOrder();
        mainPage.orderInMain();

        CreateOrderPage createOrderPage = new CreateOrderPage(driver);
        createOrderPage.nameForOrder(); //Заполнение поля Имя.Contains использован для поиска инпута с минимальным количеством символов на случай если название будет изменено. По названию класса искать не стал, т.к. значение может оказаться динамическим и в будущем изменится
        createOrderPage.surnameForOrder(); //Заполнение поля Фамилия
        createOrderPage.addressForOrder(); //Заполнение поля Адрес
        createOrderPage.metroSearchForOrder(); //Вызываем выпадющий список со странцией метро и вводим туда значение
        createOrderPage.metroSelectForOrder(); //Находим совпадения в селекте и выбираем станцию метро
        createOrderPage.phoneForOrder(); //Заполнение поля телефон
        createOrderPage.nextForOrder(); //Нажимаем Далее
        createOrderPage.dateSearchForOrder(); //Вызываем виджет календаря
        createOrderPage.dateSelectForOrder(); //Выбираем дефолтную дату (сегодняшнее число)
        createOrderPage.rentSearchForOrder(); //Вызываем выпадающий список со сроком аренды
        createOrderPage.rentSelectForOrder(); //Выбираем срок аренды из селекта (в данном случае всегда будет выбираться первое значение из списка)
        createOrderPage.createButtonForOrder(); //Нажимаем на кнопку заказа
        createOrderPage.confirmForOrder(); //Подтверждаем заказ в окне
        assertTrue("Expected Massage Not Found", createOrderPage.isMessageCreateNewOrder()); //Проверяем сообщение об успешном создании заказа
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}