package lotto.modelTest;

import lotto.model.LottoTicketCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTicketCountTest {

    @Test
    void inputMoneyNullOrEmpty() {
        assertThatThrownBy(() -> new LottoTicketCount(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("  "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("1 000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("1000 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputInvalidMoneyType() {
        assertThatThrownBy(() -> new LottoTicketCount("천원"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("1ooo"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("1000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputInvalidMoneyAmount() {
        assertThatThrownBy(() -> new LottoTicketCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("1000100"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicketCount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}