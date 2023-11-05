package lotto.cashier;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashierTest {

    @DisplayName("로또 구매 개수를 계산한다.")
    @Test
    void calculateLottoCount() {
        //given
        int purchaseAmount = 10000;
        Cashier cashier = new Cashier();

        //when
        int lottoCount = cashier.calculateLottoCount(purchaseAmount);

        //then
        assertThat(lottoCount).isEqualTo(purchaseAmount / 1000);
    }
    

}
