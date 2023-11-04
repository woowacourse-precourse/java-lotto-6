package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @Test
    @DisplayName("PurchaseAmount가 잘 초기화 되는지 확인")
    void initPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("50000");

        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(50000);
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력받으면 예외 처리")
    void inputNonNumericPurchaseAmount() {
        assertThatThrownBy(() -> new PurchaseAmount("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("구입할 수 있는 최대 로또 갯수를 잘 반환하는지 확인")
    void getMaxLottoCountForBudget() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("50000");

        assertThat(purchaseAmount.getMaxLottoCountForBudget()).isEqualTo(50);
    }

}
