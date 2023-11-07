package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.model.LottoModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketsTest {

    @Test
    @DisplayName("로또 당첨 번호와 구매 로또가 일치하는지 확인합니다.")
    void matchNumber(){
        // given
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoSet lottoSet = new LottoSet(lotto,7);

        Ticket ticket = new Ticket(5000);
        Tickets tickets = new Tickets(ticket);
        tickets.generate();

        // when
        List<Integer> winRecord = tickets.matchNumber(lottoSet);

        // then
        assertThat(winRecord.size()).isEqualTo(5);
    }
}
