package lotto.util;

import static lotto.util.ErrorMessage.INPUT_DUPLICATE_NUMBER;
import static lotto.util.ErrorMessage.INPUT_NOT_IN_RANGE;
import static lotto.util.ErrorMessage.INPUT_NOT_NUMBER;
import static lotto.util.ErrorMessage.INPUT_OUT_OF_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @DisplayName("구입 금액에 숫자가 아닌 글자를 입력하면 에러 발생")
    @ParameterizedTest
    @CsvSource({"1000d", "100 0", "abcd", "1000.0"})
    public void inputMoneyNotNumber(String money) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoney(money));
    }

    @DisplayName("구입 금액에 1000원 단위가 아닌 숫자를 입력하면 에러 발생")
    @ParameterizedTest
    @CsvSource({"1111", "100", "0000"})
    public void inputMoneyNotThousand(String money) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoney(money));
    }

    @DisplayName("구입 금액에 2억이 넘는 숫자를 입력하면 에러 발생")
    @ParameterizedTest
    @CsvSource({"2000001000", "9223372036854775808"})
    public void inputTooMuchMoney(String money) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validateMoney(money));
    }

    @DisplayName("당첨 번호에 빈 문자를 입력하면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,,3,4,5,6", "1,2,3,4,5,"})
    public void inputNullException(String winningNumber) {
        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateWinningNumber(winningNumber));
        assertEquals(exception.getMessage(), INPUT_NOT_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호에 숫자가 아닌 글자를 입력하면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,a,3,4,5,6", "1,2,3,4,5,pobi", "1,2,3,4,5,-1"})
    public void inputNotNumberException(String winningNumber) {
        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateWinningNumber(winningNumber));
        assertEquals(exception.getMessage(), INPUT_NOT_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호에 1-45 가 아닌 숫자를 입력하면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,46,5,6", "1,2,3,4,5,0"})
    public void inputNotINRANGEException(String winningNumber) {
        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateWinningNumber(winningNumber));
        assertEquals(exception.getMessage(), INPUT_NOT_IN_RANGE.getMessage());
    }

    @DisplayName("당첨 번호에 6개 미만을 입력하면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "6,7,8,9,10,11,12"})
    public void inputOutOfSizeException(String winningNumber) {
        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateWinningNumber(winningNumber));
        assertEquals(exception.getMessage(), INPUT_OUT_OF_SIZE.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자를 입력하면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,1", "10,6,7,8,9,10"})
    public void inputDuplicateException(String winningNumber) {
        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateWinningNumber(winningNumber));
        assertEquals(exception.getMessage(), INPUT_DUPLICATE_NUMBER.getMessage());
    }
}
