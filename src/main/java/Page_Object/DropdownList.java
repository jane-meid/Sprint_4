package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownList {
    private WebDriver driver;

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private By orderButtonHeader = new By.ByClassName("Button_Button__ra12g");

    private By orderButtonMiddle = new By.ByXPath(".//div[@class='Button_Button__ra12g Button_Middle__1CSJM'/button");

    public DropdownList(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке "Заказать"

    public void clickOrderButton(String buttonLocation) {
        By orderButton = (buttonLocation.equals("header") ? orderButtonHeader : orderButtonMiddle);
        WebElement scrollToOrderButton = driver.findElement(orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", scrollToOrderButton);
        driver.findElement(orderButton).click();
    }

    //Клик по вопросу из списка вопросов
    public void clickQuestionListQuestion(int index) {
        By questionListQuestion = new By.ByXPath(".//div[@id='accordion__heading-" + index + "']");
        WebElement scrollToListQuestion = driver.findElement(questionListQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", scrollToListQuestion);
        driver.findElement(questionListQuestion).click();
    }

    //Получение текста ответа на вопрос из списка
    public String getAnswerListQuestion(int index) {
        By answerListQuestion = new By.ByXPath(".//div[@id='accordion__panel-" + index + "']/p");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(answerListQuestion));
        return driver.findElement(answerListQuestion).getText();
    }
}
