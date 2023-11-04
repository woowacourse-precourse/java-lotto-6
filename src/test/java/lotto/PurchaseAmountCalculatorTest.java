package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.PurchaseAmountCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountCalculatorTest {

    PurchaseAmountCalculator purchaseAmountCalculator = new PurchaseAmountCalculator();

    @Test
    void 천원_단위_확인_테스트() {
        String purchaseAmount = "15500";
        assertThatThrownBy(() -> purchaseAmountCalculator.getTicketQuantity(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_확인_테스트 (){
        String purchaseAmount = "a2000";
        assertThatThrownBy(() -> purchaseAmountCalculator.getTicketQuantity(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_범위_최소_테스트(){
        String purchaseAmount = "900";
        assertThatThrownBy(() -> purchaseAmountCalculator.getTicketQuantity(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_범위_최대_테스트(){
        String purchaseAmount = "110000";
        assertThatThrownBy(() -> purchaseAmountCalculator.getTicketQuantity(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액별_수량_확인_테스트(){
        //given
        String purchaseAmount = String.valueOf(Randoms.pickNumberInRange(1,100)*1000);
        //when
        int ticketQuantity = purchaseAmountCalculator.getTicketQuantity(purchaseAmount);
        //then
        Assertions.assertThat(ticketQuantity).isEqualTo(Integer.parseInt(purchaseAmount)/1000);
    }
}