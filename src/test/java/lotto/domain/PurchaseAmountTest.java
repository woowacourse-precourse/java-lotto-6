package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionConstant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(strings = {"900", "0"})
    void 구매_금액이_1000원_미만일_경우_예외발생(String userInput) {
        assertThatThrownBy(() -> PurchaseAmount.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.PURCHASE_MIN_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "3850", "9999"})
    void 구매_금액이_1000원_단위가_아닐_경우_예외발생(String userInput) {
        assertThatThrownBy(() -> PurchaseAmount.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.PURCHASE_REMAINDER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2000", "3000", "15000", "50000"})
    void 입력값이_1000원_단위면_정상작동(String userInput) {
        assertThatCode(() -> PurchaseAmount.from(userInput))
                .doesNotThrowAnyException();
    }
}
