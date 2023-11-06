package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    @Test
    @DisplayName("만든 LottoTickets가 제대로 된 Lotto를 담고 있는지 테스트")
    public void testLottoTicketsCreation() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        LottoTickets lottoTickets = new LottoTickets(lottos);

        assertThat(lottoTickets.getLotto()).containsExactlyInAnyOrderElementsOf(lottos);
    }
}