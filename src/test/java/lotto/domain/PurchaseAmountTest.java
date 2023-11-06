package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 0원이면 예외가 발생한다")
    @Test
    void createPurchaseAmountByZero() {
        int purchaseAmount = 0;

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("구입 금액이 단위로 나누어 떨어지지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 999, 1001, 9999})
    void createPurchaseAmountByNotDivisibleAmount(int purchaseAmount) {

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("구매 수량을 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 100000})
    void createPurchaseAmount(int purchaseAmount) {

        PurchaseAmount createdPurchaseAmount = new PurchaseAmount(purchaseAmount);

        int actual = createdPurchaseAmount.getQuantity();
        Assertions.assertThat(actual).isEqualTo(purchaseAmount / 1000); // TODO: 상수 클래스 만들 때, 1000 변경하기
    }
}
