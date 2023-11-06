package lotto.validator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

    @Test
    void isNumber_정상() {
        String input = "45";
        boolean expected = true;

        boolean result = ValidationUtil.isNumber(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void isNumber_정상_엄청큰수() {
        String input = "9999999999999999999999999999999999999999999999";
        boolean expected = true;

        boolean result = ValidationUtil.isNumber(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void isNumber_정상_음수() {
        String input = "-45";
        boolean expected = true;

        boolean result = ValidationUtil.isNumber(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void isNumber_비정상입력() {
        String input = "abc";
        boolean expected = false;

        boolean result = ValidationUtil.isNumber(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void isInputFirstZero_첫입력_0으로_시작() {
        String input = "0008000";
        boolean expected = true;

        boolean result = ValidationUtil.isInputFirstZero(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

}