package lotto.validation;

import static lotto.validation.MoneyValidation.isConvertibleToInt;
import static lotto.validation.MoneyValidation.isGreaterThanMinValue;
import static lotto.validation.MoneyValidation.isNotDivisibleBy;
import static lotto.validation.MoneyValidation.validateMoney;
import static lotto.view.ErrorMessage.ILLEGAL_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyValidationTest {

    @DisplayName("구입 금액이 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "a123", "123a", "1as123", "  123", "123   ", "2147483648"})
    void 예외테스트_isConvertibleToInt(String input) {   // "123", "0", "1523123" 는 통과 안됨.
        assertThatThrownBy(() -> isConvertibleToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_MONEY.getMessage());
    }

    @DisplayName("구입 금액이 숫자일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0", "123", "10", "1239123", "2147483647"})
    void 통과테스트_isConvertibleToInt(String input) {
        //when
        boolean result = isConvertibleToInt(input);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("구입 금액이 최소 구매 금액보다 작을 경우")
    @ParameterizedTest
    @ValueSource(ints = {999, 0, 123, 500})
    void 예외테스트_isGreaterThanMinValue(int money) { // 1000 은 통과 안됨.
        assertThatThrownBy(() -> isGreaterThanMinValue(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_MONEY.getMessage());
    }

    @DisplayName("구입 금액이 최소 구매을 만족했을 경우")
    @ParameterizedTest
    @ValueSource(ints = {1000, 1020, 1030, 100000000})
    void 통과테스트_isGreaterThanMinValue(int money) {
        //when
        boolean result = isGreaterThanMinValue(money);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("구입 금액이 로또 금액으로 나누어 떨어지지 않을 경우")
    @ParameterizedTest
    @ValueSource(ints = {1999, 41234, 2123, 6500})
    void 예외테스트_isNotDivisibleBy(int money) {    // 5000, 10000, 2000000000 은 통과 안됨.
        assertThatThrownBy(() -> isNotDivisibleBy(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_MONEY.getMessage());
    }

    @DisplayName("구입 금액이 로또 금액으로 나누어 떨어질 않을 경우")
    @ParameterizedTest
    @ValueSource(ints = {5000, 10000, 2000000000})
    void 통과테스트_isNotDivisibleBy(int money) {
        //when
        boolean result = isNotDivisibleBy(money);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("구입 가격 관련 통합 유효성 검사 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {"", "a123", "123a", "1as123", "  123", "123   ", "999", "0", "123",
            "500", "1999", "41234", "2312", "6500", "2147483648"})
    void 예외테스트_validateMoney(String input) {
        assertThatThrownBy(() -> validateMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_MONEY.getMessage());
    }

    @DisplayName("구입 가격 관련 통합 유효성 검사 통과 체크")
    @ParameterizedTest
    @ValueSource(strings = {"5000", "10000", "2000000000"})
    void 통과테스트_validateMoney(String input) {
        //when
        boolean result = validateMoney(input);
        //then
        assertThat(result).isTrue();
    }
}
