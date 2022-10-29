import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.MainPage;

import static org.junit.Assert.assertEquals;

public class QuestionTest {
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

    @After
    public void cleanUp() {
        driver.quit();
    }
}