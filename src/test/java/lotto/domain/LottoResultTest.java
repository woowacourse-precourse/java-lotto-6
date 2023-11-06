package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class LottoResultTest {

    List<Lotto> UserLottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 10, 8, 9))
    );

    WinningNumber winLotto = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);


    @Test
    @DisplayName("플레이어의 당첨된 등급의 개수를 비교후 일치하면 통과한다.")
    void testCalculateLottoRankAndCount() {
        LottoResult lottoResult = new LottoResult();
        Player player = new Player(UserLottoList, 8000);
        lottoResult.calculateRankCounts(player.checkLottoTickets(winLotto));
        int lotto = lottoResult.getLottoCountByRank(LottoRank.FIFTH);
        Assertions.assertEquals(1, lotto);
    }


    @Test
    @DisplayName("플레이어의 수익률을 반환후 기대값과 일치하면 통과")
    void testCalculateUserProfit() {
        LottoResult lottoResult = new LottoResult();
        Player player = new Player(UserLottoList, 8000);
        double userProfit = lottoResult.calculateProfit(player.checkLottoTickets(winLotto),
                player.getMoney());
        Assertions.assertEquals("62.5", userProfit);
    }

}