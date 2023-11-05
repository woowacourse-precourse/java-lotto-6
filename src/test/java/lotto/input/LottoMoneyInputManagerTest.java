package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyInputManagerTest {

    @DisplayName("로또 구입 금액이 너무 크거나 숫자가 아닌 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2147483001", "ㅁ", "a", "1234a", "a1234", " 12343", "123454 "})
    void lottoBuyMoneyOverflowException(String input) {
        assertThatThrownBy(() -> LottoMoneyInputManager.fromString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WRONG_LOTTO_NUMBER);
    }

    @DisplayName("로또 구입 금액이 1000의 배수 아닌 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "999", "1234567", "2147482999"})
    void lottoBuyMoneyMultipleException(String input) {
        Assertions.assertThatThrownBy(() -> LottoMoneyInputManager.fromString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MONEY_IS_NOT_MULTIPLE_OF_LOTTO_PRICE);
    }

    @DisplayName("정상 동쟉 테스트")
    @ParameterizedTest
    @CsvSource(value = {"'2000', 2000", "'2147483000', 2147483000", "'1000', 1000"})
    void ok(String input, int expected) {
        assertThat(LottoMoneyInputManager.fromString(input))
                .isEqualTo(expected);
    }
}