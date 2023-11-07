package lotto.domain;

import static lotto.utils.constants.LottoConstants.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    PurchaseAmount purchaseAmount;

    @Test
    void 천원_단위_확인_테스트() {
        int inputAmount = 15500;
        assertThatThrownBy(() -> purchaseAmount  = new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_범위_최소_테스트() {
        int inputAmount = 900;
        assertThatThrownBy(() -> purchaseAmount  = new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_범위_최대_테스트() {
        int inputAmount = 110000;
        assertThatThrownBy(() -> purchaseAmount  = new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액별_수량_확인_테스트() {
        //given
        String inputValue = String.valueOf(Randoms.pickNumberInRange(1, 100) * LOTTO_TICKET_PRICE);
        int inputAmount = Converter.stringToInt(inputValue);
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        //when
        int ticketQuantity =purchaseAmount.getTicketQuantity();
        //then
        Assertions.assertThat(ticketQuantity).isEqualTo(inputAmount / LOTTO_TICKET_PRICE);
    }
}