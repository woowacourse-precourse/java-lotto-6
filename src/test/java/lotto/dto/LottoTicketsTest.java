package lotto.dto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.Lotto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {
    @Test
    @DisplayName("로또 티켓 목록에 강제로 로또를 추가하면 예외가 발생한다.")
    void lottoTicketsForceAdd() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto));
        List<Lotto> lottoBundle = lottoTickets.getLottoTickets();
        assertThrows(UnsupportedOperationException.class,
                () -> lottoBundle.add(new Lotto(List.of(7, 8, 9, 10, 11, 12))));
    }
}
