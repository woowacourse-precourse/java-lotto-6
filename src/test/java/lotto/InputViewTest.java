package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputViewTest {
    InputView inputView = new InputView();
    @Test
    void 구입_금액_천원_단위_예외_테스트() {
        String purchaseAmount = "1500";
        assertThatThrownBy(() -> inputView.inputPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
    }

    @Test
    void 구입_금액_천원_이하_예외_테스트() {
        String purchaseAmount = "999";
        assertThatThrownBy(() -> inputView.inputPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    void 구입_금액_숫자_구성_예외_테스트() {
        String purchaseAmount = "1000a";
        assertThatThrownBy(() -> inputView.inputPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자로만 구성됩니다.");
    }
}
