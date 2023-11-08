package lotto;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    @DisplayName("개수에 맞는 로또 티켓을 구매하여 번호 생성")
    @Test
    void purchaseLottoTickets() {
        LottoService lottoService = new LottoService();
        long amount = 3;

        List<Lotto> result = lottoService.purchaseLottoTickets(amount);

        assertThat(result.size()).isEqualTo(amount);
    }

    @DisplayName("로또 티켓들과 당첨 번호를 비교하여 결과 갱신")
    @Test
    void compareForEachTickets_and_UpdateResult() {
        List<Lotto> purchased = List.of(new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(4,5,6,7,8,9)));
        Lotto winning = new Lotto(List.of(4,5,6,10,11,12));
        LottoService lottoService = new LottoService();

        lottoService.compareForEachTickets(purchased, winning, 10);

        assertThat(GameResult.FIFTH_PRIZE.getResultCount()).isEqualTo(2);
    }
}
