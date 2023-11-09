package lotto.model;

import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {40001, 1001, 5555, 9999})
    void createPurchaseAmountByNotThousand(int purchaseAmount) {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NON_THOUSAND_UNIT_AMOUNT_EXCEPTION.getMessage());
    }

    @DisplayName("구입 금액이 1,000원 미만일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 999})
    void createPurchaseAmountByLessThanThousand(int purchaseAmount) {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MIN_PURCHASE_AMOUNT_EXCEPTION.getMessage());
    }

    @DisplayName("구입 금액이 100,000원 초과일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {100001, 1000000, 1000001})
    void createPurchaseAmountByMoreThanHundredThousand(int purchaseAmount) {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EXCEED_MAX_PURCHASE_AMOUNT_EXCEPTION.getMessage());
    }

    @DisplayName("구입 금액이 1,000원 단위이고 최대 금액인 100,000원 이하일 때 구입 금액이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 40000, 100000})
    void createPurchaseAmountByThousand(int purchaseAmount) {
        PurchaseAmount purchaseAmountObject = new PurchaseAmount(purchaseAmount);
        Assertions.assertThat(purchaseAmountObject).isInstanceOf(PurchaseAmount.class);
    }
}
