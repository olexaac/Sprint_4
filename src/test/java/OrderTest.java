import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.CreateOrderPage;
import ru.yandex.praktikum.model.MainPage;

import static org.junit.Assert.assertTrue;

public class OrderTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
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

