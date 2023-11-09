package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseMoneyTest {
    private PurchaseMoney purchaseMoney;

    @BeforeEach
    void setUp() {
        purchaseMoney = new PurchaseMoney(5000);
    }

    @DisplayName("구입 금액의 숫자가 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createPurchaseMoneyByUnderRangedNumber() {
        assertThatThrownBy(() -> new PurchaseMoney(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액의 숫자가 천단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseMoneyByNotThousandUnitNumber() {
        assertThatThrownBy(() -> new PurchaseMoney(110002))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액으로 로또 수량을 계산할 수 있다.")
    @Test
    void calculateLottoQuantity() {
        int result = purchaseMoney.calculateLottoQuantity();

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("구입 금액에 해당하는 액수를 반환한다.")
    @Test
    void getAmount() {
        int result = purchaseMoney.getAmount();

        assertThat(result).isEqualTo(5000);
    }
}