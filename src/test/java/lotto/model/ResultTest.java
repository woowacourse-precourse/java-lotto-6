package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.model.PrizeRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

        Result result = new Result(jackpot, lottos);

        // when
        result.calculateWinningRanks();

        // then
        assertThat(result.getCountByRank(FIRST)).isEqualTo(1);
        assertThat(result.getCountByRank(SECOND)).isEqualTo(1);
        assertThat(result.getCountByRank(THIRD)).isEqualTo(1);
        assertThat(result.getCountByRank(FOURTH)).isEqualTo(1);
        assertThat(result.getCountByRank(FIFTH)).isEqualTo(2);
    }

}