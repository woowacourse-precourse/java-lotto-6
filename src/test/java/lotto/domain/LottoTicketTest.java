package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓이 null일 경우 예외 발생")
    void 로또_티켓이_null일_경우_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new LottoTicket(null));
    }

    @Test
    @DisplayName("로또 티켓이 비어있을 경우 예외 발생")
    void 로또_티켓이_비어있을_경우_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new LottoTicket(Collections.emptyList()));
    }
}
