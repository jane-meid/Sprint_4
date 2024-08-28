import Page_Object.DropdownList;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import Page_Object.*;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class DidPopUpWindowAppearWithMessageAboutSuccessfulCreationOrder extends BaseTest {
    private final String buttonType;
    private final String name;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    public DidPopUpWindowAppearWithMessageAboutSuccessfulCreationOrder(String buttonType, String name, String secondName, String address, String metroStation, String phoneNumber, String date, String period, String color, String comment) {
        this.buttonType = buttonType;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {
                        "header",
                        "Максим",
                        "Бровкин",
                        "ул. Пушкина, 55",
                        "Черкизовская",
                        "88008008080",
                        "31.08.2024",
                        "сутки",
                        "grey",
                        ""
                },
                {
                        "body",
                        "Александр",
                        "Аксенов",
                        "ул. Колотушкина, 7",
                        "Сокольники",
                        "88008008080",
                        "30.08.2024",
                        "двое суток",
                        "black",
                        "Привет"
                },
        };
    }

    @Test
    public void DidPopUpWindowAppearWithMessageAboutSuccessfulCreationOrder() {

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        DropdownList objDropdownList = new DropdownList(driver);
        CustomerInformationForm objCustomerInformationForm = new CustomerInformationForm(driver);
        OrderInformaitionForm objOrderInformaitionForm = new OrderInformaitionForm(driver);

        objDropdownList.clickOrderButton(buttonType);
        objCustomerInformationForm.whollyCustomerInformationForm(
                name,
                secondName,
                address,
                metroStation,
                phoneNumber);
        objCustomerInformationForm.clickNextButton();
        objOrderInformaitionForm.checkDateFieldIsActive();
        objOrderInformaitionForm.whollyOrderInformationForm(
                date,
                period,
                color,
                comment);
        objOrderInformaitionForm.clickOrderButton();
        objOrderInformaitionForm.clickAppearYesButton();
        objOrderInformaitionForm.orderPlacedHeaderAppear();
    }

}

