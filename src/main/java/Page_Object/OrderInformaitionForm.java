package Page_Object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderInformaitionForm {
    private WebDriver driver;
    private By dateField = new By.ByXPath(".//input[@placeholder='* Когда привезти самокат']");
    private By periodField = new By.ByXPath(".//input[@placeholder='* Срок аренды']");
    private By commentField = new By.ByXPath(".//input[@placeholder='* Комментарий для курьера']");
    private By orderButton = new By.ByXPath(".//button[text()='Заказать']");
    private By appearYesButton = new By.ByXPath(".//button[text()='Да']");
    private By orderPlacedHeader = new By.ByXPath(".//button[text()='Заказ оформлен']");

    public OrderInformaitionForm(WebDriver driver) {
        this.driver = driver;
    }

    public void checkDateFieldIsActive() {
        Assert.assertTrue(driver.findElement(dateField).isEnabled());
    }

    public void enterDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void choosePeriod(String period) {
        driver.findElement(periodField).click();
        driver.findElement(By.xpath(".//div[text()='" + period + "']")).click();
    }

    public void chooseColor(String color){
        driver.findElement(By.xpath(".//label[@class='Chteckbox_Label__3wxSf']/input[@id='" + color + "']")).click();
    }
    public void enterComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickAppearYesButton(){
        driver.findElement(appearYesButton).click();
    }
    public void whollyOrderInformationForm(String date, String period, String color, String comment) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(periodField).click();
        driver.findElement(By.xpath(".//div[text()='" + period + "']")).click();
        driver.findElement(By.xpath(".//label[@class='Chteckbox_Label__3wxSf']/input[@id='" + color + "']")).click();
        driver.findElement(commentField).sendKeys(comment);
    }

    public void orderPlacedHeaderAppear() {
        Assert.assertTrue(driver.findElement(orderPlacedHeader).isDisplayed());
    }
}

