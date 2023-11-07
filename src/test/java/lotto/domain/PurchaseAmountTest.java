package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999, 1001, 1500})
    void 구매금액_생성_실패_테스트(int number) {
        assertThatThrownBy(() -> new PurchaseAmount(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 10000, 50000, 100000})
    void 구매금액_생성_성공_테스트(int number) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(number);
        Assertions.assertThat(purchaseAmount.getAmount()).isEqualTo(number);
    }
}