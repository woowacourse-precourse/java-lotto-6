package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @DisplayName("1,000원 단위로 나누어 떨어지는 구입 금액으로 생성시 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 20000, 3000000, 40000000})
    void createPurchaseAmountSuccessTest(int purchaseAmount) {
        assertThatCode(() -> new PurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("1,000원 단위로 나누어 떨어지지 않는 구입 금액으로 생성시 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 10, 100, 1001, 20002, 300312, 4124315})
    void createPurchaseAmountFailTest(int purchaseAmount) {
        assertThatCode(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("구입금액은 1,000원 단위만 가능합니다. 입력값 : %d", purchaseAmount));
    }

    @DisplayName("구매 금액당 횟수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1000, 1", "10000, 10"})
    void getAvailablePurchaseCountsTest(int inputPurchaseAmount, int availableCounts) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
        assertThat(purchaseAmount.getAvailablePurchaseCounts()).isEqualTo(availableCounts);
    }

    @DisplayName("입력한 구매 금액을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000})
    void getPurchaseAmountTest(int inputPurchaseAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(inputPurchaseAmount);
    }
}
