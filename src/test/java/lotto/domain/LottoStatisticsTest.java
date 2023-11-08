package lotto.domain;

import lotto.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    @DisplayName("로또 1등이 나오는지 확인한다.")
    @Test
    void checkFirstPrize() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 1000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(0);
        assertThat(statistics.getWinningMoney()).isEqualTo(2000000000L);
        assertThat(statistics.getWinningRate()).isEqualTo(200000000.0);
    }

    @DisplayName("로또 2등이 나오는지 확인한다.")
    @Test
    void checkSecondPrize() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 1000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(0);
        assertThat(statistics.getWinningMoney()).isEqualTo(30000000L);
        assertThat(statistics.getWinningRate()).isEqualTo(3000000.0);
    }

    @DisplayName("로또 3등이 나오는지 확인한다.")
    @Test
    void checkThirdPrize() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 1000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(0);
        assertThat(statistics.getWinningMoney()).isEqualTo(1500000L);
        assertThat(statistics.getWinningRate()).isEqualTo(150000.0);
    }

    @DisplayName("로또 4등이 나오는지 확인한다.")
    @Test
    void checkFourthPrize() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 10)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 1000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(0);
        assertThat(statistics.getWinningMoney()).isEqualTo(50000L);
        assertThat(statistics.getWinningRate()).isEqualTo(5000.0);
    }

    @DisplayName("로또 5등이 나오는지 확인한다.")
    @Test
    void checkFifthPrize() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 7, 10, 11)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 1000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(0);
        assertThat(statistics.getWinningMoney()).isEqualTo(5000L);
        assertThat(statistics.getWinningRate()).isEqualTo(500.0);
    }

    @DisplayName("로또 당첨 실패가 나오는지 확인한다.")
    @Test
    void checkNoPrize() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1, 2, 7, 10, 11, 12)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 1000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(1);
        assertThat(statistics.getWinningMoney()).isEqualTo(0L);
        assertThat(statistics.getWinningRate()).isEqualTo(0.0);
    }

    @DisplayName("로또 1등부터 당첨 실패까지 모두 나오는지 확인한다.")
    @Test
    void checkAllPrize() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 10)));
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 10)));
        purchasedLottos.add(new Lotto(List.of(1, 2, 3, 7, 10, 11)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 5000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(1);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(0);
        assertThat(statistics.getWinningMoney()).isEqualTo(2031555000L);
        assertThat(statistics.getWinningRate()).isEqualTo(40631100.0);
    }

    @DisplayName("로또 1등 10000번이 나오는지 확인한다.")
    @Test
    void checkFirstPrizeFor10000times() {
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            purchasedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }

        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        int amount = 10000000;

        LottoStatistics statistics = new LottoStatistics(purchasedLottos, winningLotto, bonus, amount);
        assertThat(statistics.getRankCounter().get(LottoRank.FIRST_PRIZE)).isEqualTo(10000);
        assertThat(statistics.getRankCounter().get(LottoRank.SECOND_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.THIRD_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.FIFTH_PRIZE)).isEqualTo(0);
        assertThat(statistics.getRankCounter().get(LottoRank.NO_PRIZE)).isEqualTo(0);
        assertThat(statistics.getWinningMoney()).isEqualTo(20000000000000L);
        assertThat(statistics.getWinningRate()).isEqualTo(200000000.0);
    }
}
