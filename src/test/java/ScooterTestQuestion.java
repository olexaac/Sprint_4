import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.CreateOrderPage;
import ru.yandex.praktikum.model.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScooterTestQuestion {
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
        mainPage.clickQuestionNumbOne(); //Ответ на первый вопрос

        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", mainPage.viewAnswerQuestionOne());
    }

    @Test
    public void checkAccordionAnswerTwoExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        mainPage.clickQuestionNumbTwo(); //Ответ на второй вопрос

        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", mainPage.viewAnswerQuestionTwo());
    }

    @Test
    public void checkAccordionAnswerThreeExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        mainPage.clickQuestionNumbThree(); //Ответ на третий вопрос

        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", mainPage.viewAnswerQuestionThree());
    }

    @Test
    public void checkAccordionAnswerFourExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        mainPage.clickQuestionNumbFour(); //Ответ на четвертый вопрос

        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", mainPage.viewAnswerQuestionFour());
    }

    @Test
    public void checkAccordionAnswerFiveExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        mainPage.clickQuestionNumbFive(); //Ответ на пятый вопрос

        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", mainPage.viewAnswerQuestionFive());
    }

    @Test
    public void checkAccordionAnswerSixExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        mainPage.clickQuestionNumbSix(); //Ответ на шестой вопрос

        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", mainPage.viewAnswerQuestionSix());
    }

    @Test
    public void checkAccordionAnswerSevenExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        mainPage.clickQuestionNumbSeven(); //Ответ на седьмой вопрос

        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", mainPage.viewAnswerQuestionSeven());
    }

    @Test
    public void checkAccordionAnswerEightExpectText() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.viewAccordion();
        mainPage.clickQuestionNumbEight(); //Ответ на восьмой вопрос

        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", mainPage.viewAnswerQuestionEight());
    }

    @Test
    public void createOrderHeader() { //Создание заказа по клику на кнопку в хедере
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.orderInHeader(); //Нажатие на кнопку заказа в шапке

        CreateOrderPage createOrderPage = new CreateOrderPage(driver);
        createOrderPage.nameForOrder("Алексей"); //Заполнение поля Имя.Contains использован для поиска инпута с минимальным количеством символов на случай если название будет изменено. По названию класса искать не стал, т.к. значение может оказаться динамическим и в будущем изменится
        createOrderPage.surnameForOrder("Петров"); //Заполнение поля Фамилия
        createOrderPage.addressForOrder("Пушкина, д. 22"); //Заполнение поля Адрес
        createOrderPage.metroSearchForOrder("Сокол"); //Вызываем выпадющий список со странцией метро и вводим туда значение
        createOrderPage.metroSelectForOrder(); //Находим совпадения в селекте и выбираем станцию метро
        createOrderPage.phoneForOrder("79548882365"); //Заполнение поля телефон
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
        createOrderPage.nameForOrder("Алексей"); //Заполнение поля Имя.Contains использован для поиска инпута с минимальным количеством символов на случай если название будет изменено. По названию класса искать не стал, т.к. значение может оказаться динамическим и в будущем изменится
        createOrderPage.surnameForOrder("Петров"); //Заполнение поля Фамилия
        createOrderPage.addressForOrder("Пушкина, д. 22"); //Заполнение поля Адрес
        createOrderPage.metroSearchForOrder("Сокол"); //Вызываем выпадющий список со странцией метро и вводим туда значение
        createOrderPage.metroSelectForOrder(); //Находим совпадения в селекте и выбираем станцию метро
        createOrderPage.phoneForOrder("79536667858"); //Заполнение поля телефон
        createOrderPage.nextForOrder(); //Нажимаем Далее
        createOrderPage.dateSearchForOrder(); //Вызываем виджет календаря
        createOrderPage.dateSelectForOrder(); //Выбираем дефолтную дату (сегодняшнее число)
        createOrderPage.rentSearchForOrder(); //Вызываем выпадающий список со сроком аренды
        createOrderPage.rentSelectForOrder(); //Выбираем срок аренды из селекта (в данном случае всегда будет выбираться первое значение из списка)
        createOrderPage.createButtonForOrder(); //Нажимаем на кнопку заказа
        createOrderPage.confirmForOrder(); //Подтверждаем заказ в окне
        assertTrue("Expected Message Not Found", createOrderPage.isMessageCreateNewOrder()); //Проверяем сообщение об успешном создании заказа
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}