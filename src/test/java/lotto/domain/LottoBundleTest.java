package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {

    @Test
    @DisplayName("로또 뭉치 생성시 로또를 오름차순으로 정렬해 생성한다.")
    void create_lotto_bundle_with_ascending_lotteries() {
        // given
        List<List<Integer>> lotteries = createNewLotteries();
        List<List<Integer>> testLotteries = createNewLotteries();

        // when
        LottoBundle lottoBundle = new LottoBundle(lotteries);

        // then
        assertThat(lottoBundle.getLotteries()).isEqualTo(createExpectedLotteries(testLotteries));
    }

    private static List<List<Integer>> createNewLotteries() {
        return Arrays.asList(
                Arrays.asList(14, 3, 5, 7, 9, 43),
                Arrays.asList(2, 8, 6, 14, 10, 11),
                Arrays.asList(17, 25, 41, 31, 35, 3));
    }

    private static List<Lotto> createExpectedLotteries(List<List<Integer>> lotteries) {
        sortLotteries(lotteries);
        List<Lotto> expectedLotteries = new ArrayList<>();
        for (List<Integer> lottoNumbers : lotteries) {
            expectedLotteries.add(new Lotto(lottoNumbers));
        }
        return expectedLotteries;
    }

    private static void sortLotteries(List<List<Integer>> lotteries) {
        for (List<Integer> lottery : lotteries) {
            Collections.sort(lottery);
        }
    }

    @Test
    @DisplayName("로또 뭉치의 순위를 확인할 수 있다.")
    void check_rankings() {
        // given
        LottoBundle lottoBundle = new LottoBundle(createNewLotteries());
        Lotto winnerLotto = new Lotto(Arrays.asList(3, 5, 7, 9, 14, 43));
        Bonus bonus = new Bonus(winnerLotto, 6);

        // when
        Map<Rank, Integer> winningLottoTable = lottoBundle.checkRankings(winnerLotto, bonus);


        // then
        assertThat(winningLottoTable).isEqualTo(createResultTable());
    }

    private Map<Rank, Integer> createResultTable() {
        Map<Rank, Integer> rankTable = new HashMap<>();
        rankTable.put(FIFTH, 0);
        rankTable.put(FOURTH, 0);
        rankTable.put(THIRD, 0);
        rankTable.put(SECOND, 0);
        rankTable.put(FIRST, 1);
        return rankTable;
    }

    @Test
    @DisplayName("로또 뭉치의 사이즈를 알려준다.")
    void size() {
        // given
        LottoBundle lottoBundle = new LottoBundle(createNewLotteries());

        // when
        int size = lottoBundle.size();

        // then
        assertThat(size).isEqualTo(3);
    }
}
