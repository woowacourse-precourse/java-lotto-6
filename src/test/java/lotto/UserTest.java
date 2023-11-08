package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {

    private static final int ONE_LOTTO = 1000;


    @DisplayName("사용자가 로또 구입시 개수가 정확한지 확인")
    @Test
    void purchaseLotto() {
        int money = 14000;

        LottoSeller lottoSeller = new LottoSeller(new LottoGenerator());
        List<Lotto> lottos = lottoSeller.sellLotto(money);

        assertThat(lottos.size()).isEqualTo(money / ONE_LOTTO);
    }

    @DisplayName("로또 번호와 당첨 번호 비교하여 몇 개 맞추었는 지 확인")
    @Test
    void statisticRank() {
        User user = new User(10000);
        LottoSeller lottoSeller = new LottoSeller(new LottoGenerator());
        List<Lotto> lottos = user.purchaseLotto(lottoSeller);

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        HashMap<Rank, Integer> expectedRankCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.checkWinning(winningNumber);
            expectedRankCount.put(rank, expectedRankCount.getOrDefault(rank, 0) + 1);
        }

        HashMap<Rank, Integer> resultRankCount = user.statisticRank(winningNumber);

        assertEquals(expectedRankCount, resultRankCount);
    }


}