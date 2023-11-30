package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.constants.Constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.message.ExceptionMessage.*;
import static util.message.ExceptionMessage.UNIT_MESSAGE;

public class PurchaseAmountTest {
    @ParameterizedTest
    @DisplayName("구입금액을 올바르게 입력한 경우 예외가 발생하지 않는다.")
    @CsvSource("4000")
    void givenNormalAmount_thenSuccess(final int purchaseAmount) {
        assertThat(PurchaseAmount.create(purchaseAmount))
                .isInstanceOf(PurchaseAmount.class);

        assertThatCode(() -> PurchaseAmount.create(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ValueSource(strings = {"4565", "1223"})
    void givenNonDivisibleBy1000_thenFail(final int purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmount.create(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UNIT_MESSAGE.getValue(), Constants.ONE_THOUSAND.getValue()));
    }
}
