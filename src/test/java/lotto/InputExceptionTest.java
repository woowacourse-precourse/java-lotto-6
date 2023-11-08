package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputExceptionTest {

    Ui testUi = new Ui();

    @Test
    public void testCheckInteger(){

        String trueValue = "1000";
        String falseValue = "a1000";
        String falseValue2 = "1,000";
        String nullValue = "";
        String blankValue = "10 00";

        assertThatCode(()-> testUi.checkInteger(trueValue))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> testUi.checkInteger(falseValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> testUi.checkInteger(falseValue2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> testUi.checkInteger(nullValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> testUi.checkInteger(blankValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCheckNegative(){

        int trueValue = 1000;
        int falseValue = -1000;

        assertThatCode(()-> testUi.checkNegative(trueValue))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> testUi.checkNegative(falseValue))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void testCheck1000(){

        int trueValue = 3000;
        int falseValue = 2400;

        assertThat(testUi.check1000(trueValue)).isEqualTo(3);

        assertThatThrownBy(()-> testUi.check1000(falseValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testSplitInput(){

        String testValue = "1,2,3,4,5,6";
        String [] result = {"1", "2", "3", "4", "5", "6"};

        assertThat(testUi.splitInput(testValue)).isEqualTo(result);
    }

    @Test
    public void checkNumOfInput(){

        String [] trueValue = {"1", "2", "3", "4", "5", "6"};
        String [] lessValue = {"1", "2", "3", "4", "5"};
        String [] moreValue = {"1", "2", "3", "4", "5", "6", "7"};

        assertThatCode(()->testUi.checkNumOfInput(trueValue))
                .doesNotThrowAnyException();

        assertThatThrownBy(()->testUi.checkNumOfInput(lessValue))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->testUi.checkNumOfInput(moreValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void checkRangeOfInput(){

        int maxValue = 45;
        int minValue = 1;
        int falseValue = 0;
        int falseValue2 = 46;

        assertThatCode(()->testUi.checkRangeOfInput(maxValue))
                .doesNotThrowAnyException();
        assertThatCode(()->testUi.checkRangeOfInput(minValue))
                .doesNotThrowAnyException();

        assertThatThrownBy(()->testUi.checkRangeOfInput(falseValue))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->testUi.checkRangeOfInput(falseValue2))
                .isInstanceOf(IllegalArgumentException.class);

    }
}

