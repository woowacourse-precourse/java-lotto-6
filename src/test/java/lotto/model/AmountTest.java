package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {
    private static final int MINIMUM_AMOUNT = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final String NOT_INTEGER_AMOUNT_ERROR = "[ERROR] 구입 금액은 정수여야 합니다.";
    private static final String AMOUNT_LESS_THAN_MINIMUM_ERROR = "[ERROR] 구입 금액은 %d보다 작을 수 없습니다.";
    private static final String LOTTO_PRICE_UNIT_ERROR = "[ERROR] 로또는 %,d원 단위로만 구매할 수 있습니다.";

    @DisplayName("구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void createAmountByNotInteger() {
        assertThatThrownBy(() -> Amount.create("1000.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER_AMOUNT_ERROR);
    }

    @DisplayName("구입 금액이 0보다 작으면 예외가 발생한다.")
    @Test
    void createAmountByNegativeNumber() {
        assertThatThrownBy(() -> Amount.create("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(AMOUNT_LESS_THAN_MINIMUM_ERROR, MINIMUM_AMOUNT));
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createAmountByNotThousandUnit() {
        assertThatThrownBy(() -> Amount.create("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LOTTO_PRICE_UNIT_ERROR, LOTTO_PRICE));
    }
}
