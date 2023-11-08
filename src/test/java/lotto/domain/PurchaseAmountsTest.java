package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountsTest {

    @DisplayName("1000원 단위로 지불하지 않으면 예외가 발생한다.")
    @Test
    public void payTheWrongAmount() throws Exception {
        //given & when & then
        assertThatThrownBy(() -> new PurchaseAmounts(1100))
                .isInstanceOf(IllegalArgumentException.class);
    } 

}