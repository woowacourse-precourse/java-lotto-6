package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.model.Budget;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    private LottoMachine lottoMachine;
    @BeforeEach
    void setUp(){
        List<Integer> testNumbers = Arrays.asList(1,2,3,4,5,6);
        lottoMachine = new FixedLottoMachine(testNumbers);
    }
    @DisplayName("로또 수량은 금액/로또_금액 이어야 한다.")
    @Test
    void createLottoTicketTest(){
        Budget price = new Budget(3000);
        LottoTicket lottoTicket = new LottoTicket(price, lottoMachine);
        assertThat(lottoTicket.getLottoTicketSize()).isEqualTo(3);
    }

}
