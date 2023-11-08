package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerReaderTest {

    @Test
    @DisplayName("1등 로또와 보너스 숫자를 로또 뭉치와 비교해 당첨 등수와 갯수를 알려준다.")
    void check_lotteries() {
        // given
        LottoBundle lottoBundle = new LottoBundle(createLotteries());

        Lotto winnerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(winnerLotto, 7);
        WinnerReader winnerReader = new WinnerReader(winnerLotto, bonus);

        // when
        WinningLottoTable winningLottoTable = winnerReader.checkLotteries(lottoBundle);

        // then
        assertThat(winningLottoTable).isEqualTo(new WinningLottoTable(createResultTable()));
    }

    private List<List<Integer>> createLotteries() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 6, 5),
                Arrays.asList(2, 4, 44, 8, 10, 11),
                Arrays.asList(17, 1, 41, 4, 35, 3));
    }

    private Map<Rank, Integer> createResultTable() {
        Map<Rank, Integer> rankTable = new HashMap<>();
        rankTable.put(FIFTH, 1);
        rankTable.put(FOURTH, 0);
        rankTable.put(THIRD, 0);
        rankTable.put(SECOND, 0);
        rankTable.put(FIRST, 1);
        return rankTable;
    }
}
