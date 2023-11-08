package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyValidatorTest {

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {1_500, 3_200, 50_500, 4650, 1450})
    void should_Throw_Exception_When_Money_Is_Not_Divisible_By_LottoPrice(int money) {
        // when
        // then
        assertThatThrownBy(() -> MoneyValidator.verifyDivisibleBy(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_MONEY.get());
    }

    @DisplayName("구입 금액이 1000원 미만인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {400, 500, 800, 150, 100})
    void should_Throw_Exception_When_Money_Is_MinAmount(int money) {
        // when
        // then
        assertThatThrownBy(() -> MoneyValidator.verifyMinAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_MONEY_AT_LEAST.get());
    }

    @DisplayName("구입 금액이 최대 금액인 100,000원을 초과하는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {100_001, 200_000, 250_000, 1_000_000})
    void should_Throw_Exception_When_Money_Is_Above_MaxAmount(int money) {
        // when
        // then
        assertThatThrownBy(() -> MoneyValidator.verifyMaxAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXCEEDS_MAX_AMOUNT.get());
    }

    @DisplayName("음수 금액을 입력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-500, -1_000, -20_000, -3_000_000})
    void should_Throw_Exception_When_Money_Is_Negative(int money) {
        assertThatThrownBy(() -> MoneyValidator.verifyPositiveMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_AMOUNT.get());
    }
}