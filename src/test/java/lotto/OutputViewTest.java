package lotto;

import lotto.domain.LottoTicket;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    @DisplayName("로또 목록 출력 결과")
    public void lotto() {
        // given
        LottoTicket lottoTickets = new LottoTicket(3);

        // when
        OutputView.printTicket(lottoTickets);

        // then
    }
}