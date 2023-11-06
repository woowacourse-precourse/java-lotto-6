package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 0원이면 예외가 발생한다")
    @Test
    void createPurchaseAmountByZero() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(BigInteger.ZERO));
    }

    @DisplayName("구입 금액이 단위로 나누어 떨어지지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "999", "1001", "9999"})
    void createPurchaseAmountByNotDivisibleAmount(String purchaseAmount) {

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(new BigInteger(purchaseAmount)));
    }

    @DisplayName("구매 수량을 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "100000"})
    void createPurchaseAmount(String purchaseAmount) {

        PurchaseAmount createdPurchaseAmount = new PurchaseAmount(new BigInteger(purchaseAmount));

        BigInteger actual = createdPurchaseAmount.getQuantity();
        BigInteger expected = new BigInteger(purchaseAmount).divide(new BigInteger("1000"));
        Assertions.assertThat(actual.compareTo(expected)).isZero();
    }
}
