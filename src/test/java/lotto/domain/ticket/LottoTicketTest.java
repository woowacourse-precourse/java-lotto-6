package lotto.domain.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.LottoRank;
import lotto.domain.result.WinResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
        private Ticket ticket;
        private Lotto lotto;

        @BeforeEach
        void init() {
                lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                ticket = new LottoTicket(List.of(lotto, lotto));
        }

        @DisplayName("성공: Ticket 은 결과를 생성 후 반환한다.")
        @Test
        void call_checkResult_will_return_WinResult() {
                //given
                int magicNumber = 9;
                BigDecimal expectedRateOfReturn = new BigDecimal("200000000.0000");

                //when
                WinResult winResult = ticket.checkResult(lotto, magicNumber);

                //then
                assertThat(winResult).isNotNull();
                assertThat(winResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn);
                assertThat(winResult.getRanks().get(LottoRank.FIRST)).isEqualTo(2);
        }

        @DisplayName("성공: 구입한 로또의 수를 반환한다.")
        @Test
        void call_getNumOfLottoEntry() {
                //when
                long numOfLottoEntry = ticket.getNumOfLottoEntry();

                //then
                assertThat(numOfLottoEntry).isEqualTo(2);
        }
}
