package lotto.domain;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoWinningManagerTest {

    @Test
    void settlePrizeResults() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        LottoWinningManager manager = new LottoWinningManager();
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        manager.setWinningLotto(winningLotto);
        manager.settlePrizeResults(lottos);

        assertThat(manager.totalReward).isEqualTo(5000);
        assertThat(manager.prizeFrequancyTable.get(Prize.FIFTH)).isEqualTo(1);
        assertThat(manager.prizeFrequancyTable.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(manager.prizeFrequancyTable.get(Prize.THIRD)).isEqualTo(0);
        assertThat(manager.prizeFrequancyTable.get(Prize.SECOND)).isEqualTo(0);
        assertThat(manager.prizeFrequancyTable.get(Prize.FIRST)).isEqualTo(0);
    }

    @Test
    void calculateProfitRate() {
        LottoWinningManager manager = new LottoWinningManager();
        manager.totalReward = 1500000;
        manager.totalCost = 7000;
        assertThat(manager.calculateProfitRate()).isEqualTo(21428.6);
    }
}