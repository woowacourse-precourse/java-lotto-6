package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseLottoTest {

    PurchaseLotto purchaseLotto;

    @BeforeEach
    void beforeEach() {
        this.purchaseLotto = new PurchaseLotto();
    }

    @ParameterizedTest
    @ValueSource(strings = {"8000원", "800 0", "8000!", "8,000"})
    void 숫자가_아닌_금액_입력(String input) {
        assertThatThrownBy(() -> purchaseLotto.purchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    void 천원보다_적은_금액_입력() {
        assertThatCode(() -> purchaseLotto.purchase("1000")).doesNotThrowAnyException();
        assertThatThrownBy(() -> purchaseLotto.purchase("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 구매 금액은 1,000원 입니다.");
    }

    @Test
    void 천원_단위_입력() {
        assertThatCode(() -> purchaseLotto.purchase("8000")).doesNotThrowAnyException();
        assertThatThrownBy(() -> purchaseLotto.purchase("8009"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원 단위로 입력해 주세요.");
    }

    @Test
    void 발행할_로또수() {
        purchaseLotto.purchase("8000");
        assertThat(purchaseLotto.getNumberOfPurchases()).isEqualTo(8);

        purchaseLotto.purchase("18000");
        assertThat(purchaseLotto.getNumberOfPurchases()).isEqualTo(18);
    }

    @Test
    void 입력_금액_제한() {
        assertThatCode(() -> purchaseLotto.purchase("999999000")).doesNotThrowAnyException();
        assertThatThrownBy(() -> purchaseLotto.purchase("1000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000,000,000원 보다 적은 금액을 입력해주세요.");
    }
}