package lotto.domain;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinRecordTest {
    @Test
    @DisplayName("당첨 내역이 정상출력됨을 확인한다.")
    void print(){
        // given
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoSet lottoSet = new LottoSet(lotto,7);

        Ticket ticket = new Ticket(5000);
        Tickets tickets = new Tickets(ticket);
        tickets.generate();

        WinRecord winRecord = new WinRecord(lottoSet);
        winRecord.inputWinRecord(tickets);

        // when
        winRecord.print();
    }

}
