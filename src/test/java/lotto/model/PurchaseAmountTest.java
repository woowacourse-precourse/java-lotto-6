package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @Test
    @DisplayName("PurchaseAmount가 잘 초기화 되는지 확인한다")
    void initPurchaseAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(50000);

        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(50000);
    }

    @Test
    @DisplayName("구입할 수 있는 최대 로또 갯수를 잘 반환하는지 확인한다")
    void getMaxLottoCountForBudget() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(50000);

        assertThat(purchaseAmount.getMaxLottoCountForBudget()).isEqualTo(50);
    }

    @Test
    @DisplayName("1000원 미만의 금액을 입력 받았을 시 예외가 발생한다")
    void inputLessThanLeastMoney() {
        assertThatThrownBy(() -> new PurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 1000원 이상의 돈을 입력해주세요.");
    }

    @Test
    @DisplayName("1000원 단위가 아닌 금액을 입력 받았을 시 예외가 발생한다")
    void inputNotMultipleOfThousand() {
        assertThatThrownBy(() -> new PurchaseAmount(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위의 금액만 입력해주세요.");
    }

}
