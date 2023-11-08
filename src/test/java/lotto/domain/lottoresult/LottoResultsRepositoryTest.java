package lotto.domain.lottoresult;


import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.player.Player;
import lotto.domain.player.Profit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsRepositoryTest {

    @DisplayName("4등으로 로또 결과 업데이트 후 10,000원 사용한 플레이어로 이익률을 계산하면 500.0이 나온다.")
    @Test
    void lottoResultRepositoryTest_1() {
        //given
        LottoResultsRepository lottoResultsRepository = new LottoResultsRepository();
        Player player = new Player(10000, new LottoBundle());
        player.buyAndSaveRandomLottoWithAllTicket(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        //when
        lottoResultsRepository.saveLottoResult(LottoResult.FOURTH);
        //then
        Profit profit = lottoResultsRepository.calculateProfit(player);
        Assertions.assertThat(profit.getProfit()).isEqualTo(500.0);
    }
}