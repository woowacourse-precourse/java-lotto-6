package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCheckerTest {
    @DisplayName("로또 번호 6개가 당첨 번호 6개와 일치하면 1등이다.")
    @Test
    void createLottoRankingFirst() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6개 일치 -> 1등
        List<Lotto> lottos = Arrays.asList(lotto);
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7); // 발행 로또, 당첨 번호, 보너스 번호
        assertThat(winningByRank.get(1)).isEqualTo(1); // 1등 당첨 수 = 1
        assertThat(winningByRank.get(2)).isEqualTo(0); // 2등 당첨 수 = 0
        assertThat(winningByRank.get(3)).isEqualTo(0); // 3등 당첨 수 = 0
        assertThat(winningByRank.get(4)).isEqualTo(0); // 4등 당첨 수 = 0
        assertThat(winningByRank.get(5)).isEqualTo(0); // 5등 당첨 수 = 0
    }

    @DisplayName("로또 번호 6개가 당첨 번호 5개 + 보너스 번호와 일치하면 2등이다.")
    @Test
    void createLottoRankingSecond() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5개 일치, 보너스 번호 일치 -> 2등
        List<Lotto> lottos = Arrays.asList(lotto);
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7); // 발행 로또, 당첨 번호, 보너스 번호
        assertThat(winningByRank.get(1)).isEqualTo(0); // 1등 당첨 수 = 0
        assertThat(winningByRank.get(2)).isEqualTo(1); // 2등 당첨 수 = 1
        assertThat(winningByRank.get(3)).isEqualTo(0); // 3등 당첨 수 = 0
        assertThat(winningByRank.get(4)).isEqualTo(0); // 4등 당첨 수 = 0
        assertThat(winningByRank.get(5)).isEqualTo(0); // 5등 당첨 수 = 0
    }

    @DisplayName("로또 번호 5개가 당첨 번호 5개와 일치하면 3등이다.")
    @Test
    void createLottoRankingThird() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5개 일치 -> 3등
        List<Lotto> lottos = Arrays.asList(lotto);
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7); // 발행 로또, 당첨 번호, 보너스 번호
        assertThat(winningByRank.get(1)).isEqualTo(0); // 1등 당첨 수 = 0
        assertThat(winningByRank.get(2)).isEqualTo(0); // 2등 당첨 수 = 0
        assertThat(winningByRank.get(3)).isEqualTo(1); // 3등 당첨 수 = 1
        assertThat(winningByRank.get(4)).isEqualTo(0); // 4등 당첨 수 = 0
        assertThat(winningByRank.get(5)).isEqualTo(0); // 5등 당첨 수 = 0
    }

    @DisplayName("로또 번호 4개가 당첨 번호 4개와 일치하면 4등이다.")
    @Test
    void createLottoRankingFourth() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)); // 4개 일치 -> 4등
        List<Lotto> lottos = Arrays.asList(lotto);
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7); // 발행 로또, 당첨 번호, 보너스 번호
        assertThat(winningByRank.get(1)).isEqualTo(0); // 1등 당첨 수 = 0
        assertThat(winningByRank.get(2)).isEqualTo(0); // 2등 당첨 수 = 0
        assertThat(winningByRank.get(3)).isEqualTo(0); // 3등 당첨 수 = 0
        assertThat(winningByRank.get(4)).isEqualTo(1); // 4등 당첨 수 = 1
        assertThat(winningByRank.get(5)).isEqualTo(0); // 5등 당첨 수 = 0
    }

    @DisplayName("로또 번호 3개가 당첨 번호 3개와 일치하면 5등이다.")
    @Test
    void createLottoRankingFifth() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)); // 3개 일치 -> 5등
        List<Lotto> lottos = Arrays.asList(lotto);
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7); // 발행 로또, 당첨 번호, 보너스 번호
        assertThat(winningByRank.get(1)).isEqualTo(0); // 1등 당첨 수 = 0
        assertThat(winningByRank.get(2)).isEqualTo(0); // 2등 당첨 수 = 0
        assertThat(winningByRank.get(3)).isEqualTo(0); // 3등 당첨 수 = 0
        assertThat(winningByRank.get(4)).isEqualTo(0); // 4등 당첨 수 = 0
        assertThat(winningByRank.get(5)).isEqualTo(1); // 5등 당첨 수 = 1
    }

    @DisplayName("로또 번호 3개가 당첨 번호와 3개와 일치하는 로또가 3장이면 5등 3장이다.")
    @Test
    void createThreeLottosRankingFifth() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)); // 3개 일치 -> 5등
        Lotto lotto2 = new Lotto(Arrays.asList(2, 3, 4, 7, 8, 9)); // 3개 일치 -> 5등
        Lotto lotto3 = new Lotto(Arrays.asList(3, 4, 5, 7, 8, 9)); // 3개 일치 -> 5등
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);
        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7); // 발행 로또, 당첨 번호, 보너스 번호
        assertThat(winningByRank.get(1)).isEqualTo(0); // 1등 당첨 수 = 0
        assertThat(winningByRank.get(2)).isEqualTo(0); // 2등 당첨 수 = 0
        assertThat(winningByRank.get(3)).isEqualTo(0); // 3등 당첨 수 = 0
        assertThat(winningByRank.get(4)).isEqualTo(0); // 4등 당첨 수 = 0
        assertThat(winningByRank.get(5)).isEqualTo(3); // 5등 당첨 수 = 3
    }
}