package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.model.LottoModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketsTest {
    // private LottoModel lottoModel = getLottoModel();

    /*@Test
    @DisplayName("티켓 발급이 정상처리되었음을 확인한다.")
    void generateTickect(){
        // given
        Wallet wallet = new Wallet(14000);
        Tickets tickets = new Tickets(wallet);

        // when
        tickets.generate();
        lottoModel.saveTicktet(tickets);

        // then
        assertThat(lottoModel.findTickets()).isEqualTo(tickets);
    }

    @Test
    @DisplayName("구매한 티켓과 로또 당첨 번호를 비교해 일치하는 값을 가져온다.")
    void matchNumber(){
        // given
        Wallet wallet = new Wallet(14000);
        Tickets tickets = new Tickets(wallet);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Bonus bonus = new Bonus(7);

        // when
        List<Integer> winRecord = tickets.matchNumber(lotto, bonus);

        // then
        assertThat(winRecord.size()).isEqualTo(14);
    }*/

}
