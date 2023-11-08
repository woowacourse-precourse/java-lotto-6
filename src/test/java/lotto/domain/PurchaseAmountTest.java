package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    private PurchaseAmount purchaseAmount;

    @DisplayName("금액을 입력받아 객체를 생성한다.")
    @Test
    void testInstanceCreation(){
        //given
        int amount = 5000;
        //when
        //then
        purchaseAmount = new PurchaseAmount(amount);
    }

    @DisplayName("단위로 나누어떨어지지 않는 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    void toNumberOfLottos() {
        //given
        int amount = 1001;

        //when
        //then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매할 수 있는 로또 개수를 반환한다.")
    @Test
    void testToNumberOfLottos(){
        //given
        int amount = 5000;
        purchaseAmount = new PurchaseAmount(amount);

        //when
        int numberOfLottos = purchaseAmount.toNumberOfLottos();

        //then
        assertThat(numberOfLottos).isEqualTo(5);
    }
}