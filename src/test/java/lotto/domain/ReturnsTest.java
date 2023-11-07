package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReturnsTest {

    @Test
    @DisplayName("수익률이 정상 출력됨을 확인한다.")
    void print(){
        // given
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoSet lottoSet = new LottoSet(lotto,7);

        Ticket ticket = new Ticket(5000);
        Tickets tickets = new Tickets(ticket);
        tickets.generate();

        WinRecord winRecord = new WinRecord(lottoSet);
        winRecord.inputWinRecord(tickets);

        Returns returns = new Returns(5000);

        // when
        returns.calculate(winRecord);

        // then
        returns.print();
    }

}
