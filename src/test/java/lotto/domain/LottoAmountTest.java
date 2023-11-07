package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoAmountTest {
    @DisplayName("구입한 금액에 로또의 개수가 맞지 않으면 예외가 발생한다.")
    @Test
    void createAmountByLottoCount(){
        LottoAmount amount = new LottoAmount(10000);
        int count = amount.getTicketCount();
        assertThat(count).isEqualTo(10);
    }

    @DisplayName("구입한 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void testPurchaseAmountValidate(){
        assertThatThrownBy(() -> new LottoAmount(1111))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
