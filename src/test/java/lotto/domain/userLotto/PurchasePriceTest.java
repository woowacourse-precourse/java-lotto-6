package lotto.domain.userLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoCondition.PRICE;

class PurchasePriceTest {

    @Test
    @DisplayName("1000 미만인 경우 실패")
    void When_LessThanLottoPrice_Expect_Fail() {
        Assertions.assertThatThrownBy(() -> new PurchasePrice(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 " + PRICE.getValue()+ "원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않는 경우 실패")
    void When_NotDivisibleByLottoPrice_Expect_Fail() {
        Assertions.assertThatThrownBy(() -> new PurchasePrice(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 " + PRICE.getValue()+ "원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("1000 단위인 경우 성공")
    void When_DivisibleByLottoPrice_Expect_Success() {
        // given
        PurchasePrice purchasePrice = new PurchasePrice(2000);

        // then
        Assertions.assertThat(purchasePrice).isNotNull();
    }
}
