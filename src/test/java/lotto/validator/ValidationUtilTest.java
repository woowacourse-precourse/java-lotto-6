package lotto.validator;


import java.util.List;
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

    @Test
    void isDuplicateNumbers_중복_없는_리스트_입력() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 9);
        boolean expected = false;

        boolean result = ValidationUtil.isDuplicateNumbers(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void isDuplicateNumbers_중복_있는_리스트_입력() {
        List<Integer> input = List.of(1, 1, 2, 3, 4, 5);
        boolean expected = true;

        boolean result = ValidationUtil.isDuplicateNumbers(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void isOutOfRange_범위_안_입력() {
        int input = 9;
        boolean expected = false;

        boolean result = ValidationUtil.isOutOfRange(1, 45, input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void isOutOfRange_범위_밖_입력() {
        int input = 51;
        boolean expected = true;

        boolean result = ValidationUtil.isOutOfRange(1, 45, input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

}