package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createLottoAmountDivisibleBy1000() {
        assertThatThrownBy(() -> new LottoAmount().setMoney(1300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따라 로또 티켓 수량이 결정된다.")
    @Test
    void getTickets() {
        int result = 8;
        LottoAmount lottoAmount = new LottoAmount();
        lottoAmount.setMoney(8000);
        assertThat(result).isEqualTo(lottoAmount.getTickets());
    }
}
