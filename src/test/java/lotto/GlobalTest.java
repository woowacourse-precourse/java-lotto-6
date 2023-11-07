package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class GlobalTest {

    @DisplayName("로또 발행 개수 맞는지 확인")
    @Test
    void getLottoCount() {
        Global global = new Global();
        int money = 5000;
        int lottoCount = global.getLottoCount(money);
        int expectedCount = 5;

        assertThat(lottoCount).isEqualTo(expectedCount);
    }

    @DisplayName("발행 개수만큼 로또 발행했는지 확인")
    @Test
    void getIssuedLottoList() {
        Global global = new Global();
        List<Lotto> issuedLottoList = global.getIssuedLottos(3);
        int listSize = issuedLottoList.size();
        int expectedSize = 3;

        assertThat(listSize).isEqualTo(expectedSize);
    }

    @DisplayName("1등(6개 일치) 개수 계산")
    @Test
    void calculateFirstRanking() {
        Global global = new Global();
        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        global.setIssuedLottos(issuedLottos);

        HashMap<Rank, Integer> rankStatistics = global.calculateRanking(winningLotto);
        int expectedCount = getExpectedCount(rankStatistics, Rank.FIRST);
        assertThat(expectedCount).isEqualTo(1);
    }

    @DisplayName("2등(5개+보너스) 개수 계산")
    @Test
    void calculateSecondRanking() {
        Global global = new Global();
        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        global.setIssuedLottos(issuedLottos);

        HashMap<Rank, Integer> rankStatistics = global.calculateRanking(winningLotto);
        int expectedCount = getExpectedCount(rankStatistics, Rank.SECOND);
        assertThat(expectedCount).isEqualTo(2);
    }

    @DisplayName("3등(5개) 개수 계산")
    @Test
    void calculateThirdRanking() {
        Global global = new Global();
        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 7, 20, 21);
        global.setIssuedLottos(issuedLottos);

        HashMap<Rank, Integer> rankStatistics = global.calculateRanking(winningLotto);
        int expectedCount = getExpectedCount(rankStatistics, Rank.THIRD);
        assertThat(expectedCount).isEqualTo(3);
    }

    @DisplayName("4등(4개) 개수 계산")
    @Test
    void calculateFourthRanking() {
        Global global = new Global();
        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 25, 26, 27);
        global.setIssuedLottos(issuedLottos);

        HashMap<Rank, Integer> rankStatistics = global.calculateRanking(winningLotto);
        int expectedCount = getExpectedCount(rankStatistics, Rank.FOURTH);
        assertThat(expectedCount).isEqualTo(5);
    }

    @DisplayName("5등(3개) 개수 계산")
    @Test
    void calculateFifthRanking() {
        Global global = new Global();
        List<Lotto> issuedLottos = createissuedLottos();
        List<Integer> winningLotto = List.of(21, 22, 23, 4, 5, 6, 7);
        global.setIssuedLottos(issuedLottos);

        HashMap<Rank, Integer> rankStatistics = global.calculateRanking(winningLotto);
        int expectedCount = getExpectedCount(rankStatistics, Rank.FIFTH);
        assertThat(expectedCount).isEqualTo(1);
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
}