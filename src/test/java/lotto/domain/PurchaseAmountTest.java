package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("1,000원 단위가 아닌 금액을 입력 시 예외 테스트")
    @Test
    void validatePurchaseAmountTest() {
        int money = 1_200;

        assertThatThrownBy(() -> new PurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,000원 단위의 금액을 입력 시 예외 테스트")
    @Test
    void validatePurchaseAmountDoesNotThrowExceptionTest() {
        int money = 1_000;

        assertThatCode(() -> new PurchaseAmount(money))
                .doesNotThrowAnyException();
    }
}