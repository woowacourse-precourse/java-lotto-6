package lotto.domain.checker;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.fake.FakeInputReader;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.LottoRank;
import lotto.domain.result.WinResult;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.Ticket;
import lotto.util.reader.ConsoleReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {
        @DisplayName("성공: Ticket 을 검사할 수 있고, 결과를 반환한다.")
        @Test
        void call_checkTicket_will_return_WinResult() {
                //given
                ConsoleReader resultInputreader = new FakeInputReader("1,2,3,4,5,6");
                ConsoleReader magicInputReader = new FakeInputReader("9");

                Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                Ticket ticket = new LottoTicket(List.of(lotto, lotto));
                Checker checker = new LottoChecker(resultInputreader, magicInputReader);
                BigDecimal expectedRateOfReturn = new BigDecimal("200000000.0000");

                //when
                WinResult winResult = checker.checkTicket(ticket);

                //then
                assertThat(winResult).isNotNull();
                assertThat(winResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn);
                assertThat(winResult.getRanks().get(LottoRank.FIRST)).isEqualTo(2);
        }
}
