import Page_Object.DropdownList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import Constants.CorrespondingText;

@RunWith(Parameterized.class)
public class DoesResponseTextMatchQuestionWhenСlicked extends BaseTest {

    private final int index;

    public DoesResponseTextMatchQuestionWhenСlicked(int index) {
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[] getIndex() {
        return new Object[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    ;

    @Test
    public void checkResponseTextMatch() {

        DropdownList objDropdownList = new DropdownList(driver);

        objDropdownList.clickQuestionListQuestion(index);
        String actual = CorrespondingText.TEXT[index];
        Assert.assertEquals("Строки не совпадают", objDropdownList.getAnswerListQuestion(index), actual);
    }
}

