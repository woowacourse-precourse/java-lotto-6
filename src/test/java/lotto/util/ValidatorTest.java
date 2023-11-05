package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {

    @DisplayName("숫자가 아닌 글자를 입력하면 에러 발생")
    @ParameterizedTest
    @CsvSource({"1000d", "100 0", "abcd", "1000.0"})
    public void inputMoneyNotNumber(String money) {
        // given
        Validator validator = new Validator();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoney(money));
    }

    @DisplayName("1000원 단위가 아닌 숫자를 입력하면 에러 발생")
    @ParameterizedTest
    @CsvSource({"1111", "100", "0000"})
    public void inputMoneyNotThousand(String money) {
        // given
        Validator validator = new Validator();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoney(money));
    }

    @DisplayName("2억이 넘는 숫자를 입력하면 에러 발생")
    @ParameterizedTest
    @CsvSource({"2000001000", "9223372036854775808"})
    public void inputTooMuchMoney(String money) {
        // given
        Validator validator = new Validator();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoney(money));
    }
}
