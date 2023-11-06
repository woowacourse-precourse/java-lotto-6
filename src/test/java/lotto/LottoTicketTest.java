package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @DisplayName("로또 구매 금액이 1000원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoTicketBy() {
        assertThatThrownBy(() -> new LottoTicket(12345))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
