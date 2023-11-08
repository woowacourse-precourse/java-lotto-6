package lotto.service;

import lotto.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketIssuerTest {
    @Test
    @DisplayName("정상적인 로또 발행기 테스트")
    void normalLottoTicketIssuerTest() {
        Integer numberOfLottoTicketToIssue = 6;

        // when
        LottoTicket lottoTicket = LottoTicketIssuer.issue(numberOfLottoTicketToIssue);

        // then
        assertThat(lottoTicket.getLottos().size())
                .isEqualTo(numberOfLottoTicketToIssue);
    }
}
