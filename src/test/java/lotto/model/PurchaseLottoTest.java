package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"8000원", "800 0", "8000!", "8,000"})
    void 숫자가_아닌_금액_입력(String input) {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        Assertions.assertThatThrownBy(() -> purchaseLotto.purchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }
}