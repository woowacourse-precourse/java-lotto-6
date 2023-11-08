package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    @DisplayName("정상적인 구매 금액인지 테스트")
    void validPurchaseAmountIsParsed() {
        // Given
        String validPurchaseAmount = "1000";

        // When
        PurchaseAmount purchaseAmount = new PurchaseAmount(validPurchaseAmount);

        // Then
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("숫자가 아닌 입력이 들어왔을 경우 테스트")
    void nonNumericPurchaseAmountThrowsException() {
        // Given
        String nonNumericPurchaseAmount = "one thousand";

        // Then
        assertThatThrownBy(() -> new PurchaseAmount(nonNumericPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바른 숫자 형식이 아닙니다.");
    }

    @Test
    @DisplayName("1000원보다 작은 금액 입력했을 경우 테스트")
    void purchaseAmountLessThan1000ThrowsException() {
        // Given
        String purchaseAmountLessThan1000 = "900";

        // Then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmountLessThan1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 보다 높은 금액을 입력해주세요.");
    }

    @Test
    @DisplayName("1000원 단위가 아닌 금액이 입력됐을 경우 테스트")
    void purchaseAmountNotDivisibleBy1000ThrowsException() {
        // Given
        String purchaseAmountNotDivisibleBy1000 = "2500";

        // Then
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmountNotDivisibleBy1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위로 구매해 주세요.");
    }
}
