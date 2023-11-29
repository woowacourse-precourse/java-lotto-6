package domain.wrapper;

import Constants.PurchaseAmountConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.message.ExceptionMessage.*;
import static util.message.ExceptionMessage.UNIT_MESSAGE;

public class AmountTest {
    @ParameterizedTest
    @DisplayName("구입금액을 올바르게 입력한 경우 예외가 발생하지 않는다.")
    @CsvSource("4000")
    void givenNormalAmount_thenSuccess(final String purchaseAmount) {
        assertThat(Amount.create(purchaseAmount))
                .isInstanceOf(Amount.class);

        assertThatCode(() -> Amount.create(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("구입금액을 빈값으로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "\n", "\t", "\r"})
    void givenBlankAmount_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> Amount.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "구입금액"));
    }

    @ParameterizedTest
    @DisplayName("구입금액을 숫자가 아닌 형태로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "12bd"})
    void givenNonNumeric_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> Amount.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue(), "구입금액"));
    }

    @ParameterizedTest
    @DisplayName("구입금액이 0이하인경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0"})
    void givenLessZero_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> Amount.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_MESSAGE.getValue(), PurchaseAmountConstant.ZERO.getValue()));
    }

    @ParameterizedTest
    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ValueSource(strings = {"4565", "1223"})
    void givenNonDivisibleBy1000_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> Amount.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UNIT_MESSAGE.getValue(), PurchaseAmountConstant.ONE_THOUSAND.getValue()));
    }
}
