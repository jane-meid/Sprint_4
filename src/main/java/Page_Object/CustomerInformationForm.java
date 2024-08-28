package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerInformationForm {
    private WebDriver driver;
    private By nameField = new By.ByXPath("//input[@placeholder='* Имя']");
    private By secondNameField = new By.ByXPath("//input[@placeholder='* Фамилия']");
    private By addressField = new By.ByXPath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = new By.ByXPath("//div[@class='select-search__value']/input");
    private By phoneNumberField = new By.ByXPath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = new By.ByXPath("//button[text()='Далее']");

    public CustomerInformationForm(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetroStation(String metroStation) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void whollyCustomerInformationForm(String name, String secondName, String address, String metroStation, String phoneNumber) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
}

