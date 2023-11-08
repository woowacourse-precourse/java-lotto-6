package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000"})
    void buyTicket_유효한_금액(String input) {
        LottoTicket.buyTicket(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "1999"})
    void buyTicket_유효하지_않은_금액(String input) {
        assertThatThrownBy(() -> LottoTicket.buyTicket(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}