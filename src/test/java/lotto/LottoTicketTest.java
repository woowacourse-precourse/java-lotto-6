package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Model.LottoTicket;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    void 생성된_로또티켓은_유효한_번호_6개를_가지고_있어야_한다() {
        LottoTicket lottoTicket = new LottoTicket();
        assertEquals(6, lottoTicket.getNumbers().size());
    }

    @Test
    void 생성된_로또티켓의_번호는_1부터_45_사이여야_한다() {
        LottoTicket lottoTicket = new LottoTicket();
        assertTrue(lottoTicket.getNumbers().stream().allMatch(number -> number >= 1 && number <= 45));
    }

    @Test
    void 생성된_로또티켓의_번호는_정렬되어야_한다() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> sortedNumbers = new ArrayList<>(lottoTicket.getNumbers());
        Collections.sort(sortedNumbers);
        assertEquals(sortedNumbers, lottoTicket.getNumbers());
    }

}
