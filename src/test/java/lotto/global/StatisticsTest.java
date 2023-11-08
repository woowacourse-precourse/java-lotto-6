package lotto.global;

import lotto.Lotto;
import lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @DisplayName("1등(6개 일치) 개수 계산")
    @Test
    void calculateFirstRanking() {
        Statistics statistics = new Statistics();

        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        HashMap<Rank, Integer> rankStatistics = statistics.calculateRanking(winningLotto, issuedLottos);
        int expectedCount = getExpectedCount(rankStatistics, Rank.FIRST);

        assertThat(expectedCount).isEqualTo(1);
    }

    @DisplayName("2등(5개+보너스) 개수 계산")
    @Test
    void calculateSecondRanking() {
        Statistics statistics = new Statistics();

        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        HashMap<Rank, Integer> rankStatistics = statistics.calculateRanking(winningLotto, issuedLottos);
        int expectedCount = getExpectedCount(rankStatistics, Rank.SECOND);

        assertThat(expectedCount).isEqualTo(2);
    }

    @DisplayName("3등(5개) 개수 계산")
    @Test
    void calculateThirdRanking() {
        Statistics statistics = new Statistics();

        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 7, 20, 21);
        HashMap<Rank, Integer> rankStatistics = statistics.calculateRanking(winningLotto, issuedLottos);
        int expectedCount = getExpectedCount(rankStatistics, Rank.THIRD);

        assertThat(expectedCount).isEqualTo(3);
    }

    @DisplayName("4등(4개) 개수 계산")
    @Test
    void calculateFourthRanking() {
        Statistics statistics = new Statistics();

        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 25, 26, 27);
        HashMap<Rank, Integer> rankStatistics = statistics.calculateRanking(winningLotto, issuedLottos);
        int expectedCount = getExpectedCount(rankStatistics, Rank.FOURTH);

        assertThat(expectedCount).isEqualTo(5);
    }

    @DisplayName("5등(3개) 개수 계산")
    @Test
    void calculateFifthRanking() {
        Statistics statistics = new Statistics();

        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(21, 22, 23, 4, 5, 6, 7);
        HashMap<Rank, Integer> rankStatistics = statistics.calculateRanking(winningLotto, issuedLottos);
        int expectedCount = getExpectedCount(rankStatistics, Rank.FIFTH);

        assertThat(expectedCount).isEqualTo(1);
    }

    @DisplayName("수익률 == 0%")
    @Test
    void calculateZeroRate() {
        Statistics statistics = new Statistics();

        HashMap<Rank, Integer> rankStatistics = new HashMap<>(
                createMap(0, 0, 0, 0, 0)
        );
        statistics.setRankStatistics(rankStatistics);
        double actualRate = statistics.calculateRateOfReturn(8000);
        double expectedRate = 0.0;

        assertThat(expectedRate).isEqualTo(actualRate);
    }

    @DisplayName("0% < 수익률 < 100%")
    @Test
    void calculateLessThan100Rate() {
        Statistics statistics = new Statistics();

        HashMap<Rank, Integer> rankStatistics = new HashMap<>(
                createMap(0, 0, 0, 0, 1)
        );
        statistics.setRankStatistics(rankStatistics);
        double actualRate = statistics.calculateRateOfReturn(8000);
        double expectedRate = 62.5;

        assertThat(expectedRate).isEqualTo(actualRate);
    }

    @DisplayName("수익률 >= 100%")
    @Test
    void calculateMoreThan100Rate() {
        Statistics statistics = new Statistics();

        HashMap<Rank, Integer> rankStatistics = new HashMap<>(
                createMap(0, 0, 1, 0, 3)
        );
        statistics.setRankStatistics(rankStatistics);
        double actualRate = statistics.calculateRateOfReturn(8000);
        double expectedRate = 18937.5;

        assertThat(expectedRate).isEqualTo(actualRate);
    }

    private List<Lotto> createissuedLottos() {
        List<Lotto> issuedLottos = new ArrayList<>();
        issuedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        issuedLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        issuedLottos.add(new Lotto(List.of(1, 2, 3, 4, 6, 7)));
        issuedLottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 10)));
        issuedLottos.add(new Lotto(List.of(1, 2, 3, 4, 10, 11)));
        return issuedLottos;
    }

    private int getExpectedCount(HashMap<Rank, Integer> rankStatistics, Rank rank) {
        return rankStatistics.get(rank);
    }

    private Map<Rank, Integer> createMap(int val1, int val2, int val3, int val4, int val5) {
        return Map.of(
                Rank.FIRST, val1,
                Rank.SECOND, val2,
                Rank.THIRD, val3,
                Rank.FOURTH, val4,
                Rank.FIFTH, val5
        );
    }
}