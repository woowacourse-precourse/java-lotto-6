package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningDetailTest {
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 3, 12, 15, 26, 36);
    private static final int BONUS_NUMBER = 23;
    private static final WinningNumbers WINNING_NUMBER = new WinningNumbers(WINNING_NUMBERS, BONUS_NUMBER);
    private static final List<Integer> FIRST_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 15, 26, 36);
    private static final List<Integer> SECOND_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 15, 23, 36);
    private static final List<Integer> THIRD_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 15, 25, 36);
    private static final List<Integer> FOURTH_RANK_LOTTO_NUMBERS = List.of(1, 3, 12, 13, 25, 36);
    private static final List<Integer> FIFTH_RANK_LOTTO_NUMBERS = List.of(1, 3, 13, 25, 36, 45);
    private static final List<Integer> NO_RANK_LOTTO_NUMBERS = List.of(1, 2, 13, 25, 36, 45);
    private static final List<Lotto> LOTTOS = new ArrayList<>();
    private static final int TWO = 2;
    private static final int ONE = 1;

    @BeforeAll
    static void init() {
        List<List<Integer>> lottoNumbers = List.of(FIRST_RANK_LOTTO_NUMBERS, SECOND_RANK_LOTTO_NUMBERS,
                THIRD_RANK_LOTTO_NUMBERS, FOURTH_RANK_LOTTO_NUMBERS, FIFTH_RANK_LOTTO_NUMBERS, NO_RANK_LOTTO_NUMBERS,
                FIRST_RANK_LOTTO_NUMBERS, THIRD_RANK_LOTTO_NUMBERS, FIFTH_RANK_LOTTO_NUMBERS);

        lottoNumbers.stream().map(Lotto::new).forEach(LOTTOS::add);
    }

    @DisplayName("1등부터 5등까지 몇 개의 로또가 당첨되었는지 구한다")
    @Test
    void computeWinningDetailTest() {
        WinningDetail winningDetail = new WinningDetail(LOTTOS, WINNING_NUMBER);
        Map<Ranking, Integer> winningCount = winningDetail.getWinningCount();

        assertThat(winningCount.get(Ranking.FIRST_RANKING)).isEqualTo(TWO);
        assertThat(winningCount.get(Ranking.SECOND_RANKING)).isEqualTo(ONE);
        assertThat(winningCount.get(Ranking.THIRD_RANKING)).isEqualTo(TWO);
        assertThat(winningCount.get(Ranking.FOURTH_RANKING)).isEqualTo(ONE);
        assertThat(winningCount.get(Ranking.FIFTH_RANKING)).isEqualTo(TWO);
        assertThat(winningCount.get(Ranking.NO_RANK)).isEqualTo(ONE);
    }
}