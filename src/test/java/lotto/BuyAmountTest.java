package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BuyAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyAmountTest {
    @DisplayName("로또 구매 금액 입력")
    @Test
    void createLottoByOverSize() {
        int payment = 8000;
        BuyAmount buyAmount = new BuyAmount(payment);

        assertThat(buyAmount.getPayment()).isEqualTo(8000);
    }
}
