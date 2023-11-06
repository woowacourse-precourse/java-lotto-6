package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.model.PrizeRank.*;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("발행된 로또들의 당첨 여부를 계산한다.")
    @Test
    void calculateWinningRanks() {
        // given
        Jackpot jackpot = new Jackpot("1,2,3,4,5,6", "45");

        // 5등
        Lotto lotto1 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        Lotto lotto2 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

        // 1등
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // 2등
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));

        // 3등
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        // 4등
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 9));

        List<Lotto> lottos = new ArrayList<>();

        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);
        lottos.add(lotto6);

        Purchase purchase = Purchase.fromPurchaseAmount("6000");

        Result result = new Result(jackpot, lottos, purchase);

        // when
        result.calculateWinningRanks();

        // then
        assertThat(result.getCountByRank(FIRST)).isEqualTo(1);
        assertThat(result.getCountByRank(SECOND)).isEqualTo(1);
        assertThat(result.getCountByRank(THIRD)).isEqualTo(1);
        assertThat(result.getCountByRank(FOURTH)).isEqualTo(1);
        assertThat(result.getCountByRank(FIFTH)).isEqualTo(2);
    }

    @DisplayName("로또 8장을 구매하고 5등(3개 일치) 하나만 있을 경우의 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        Jackpot jackpot = new Jackpot("7,8,9,20,22,24", "45");

        // 5등
        Lotto lotto1 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 9));
        Lotto lotto6 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 9));
        Lotto lotto7 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 9));
        Lotto lotto8 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 9));

        List<Lotto> lottos = new ArrayList<>();

        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);
        lottos.add(lotto6);
        lottos.add(lotto7);
        lottos.add(lotto8);

        Purchase purchase = Purchase.fromPurchaseAmount("8000");

        Result result = new Result(jackpot, lottos, purchase);

        result.calculateWinningRanks();

        // when
        Double rate = result.calculateProfitRate();

        // then
        assertThat(rate).isEqualTo(62.5);
    }

}