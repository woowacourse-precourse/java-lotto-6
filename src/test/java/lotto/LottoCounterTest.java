package lotto;

import lotto.domain.LottoCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoCounterTest {

    @Test
    @DisplayName("1000원 단위로 입력하지 않은 경우 예외가 발생한다.")
    void createLottoCounterByInvalidUnit() {
        int payment = 1100;

        assertThatThrownBy(() -> new LottoCounter(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액을 입력하면 구매할 수 있는 티켓 개수를 반환한다.")
    void calculateTicketCount() {
        LottoCounter counter = new LottoCounter(8000);

        int ticket = counter.getTicketCount();

        assertThat(ticket).isEqualTo(8);
    }
}
