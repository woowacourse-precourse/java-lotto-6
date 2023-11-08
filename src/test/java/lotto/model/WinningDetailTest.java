package lotto.model;

import static lotto.constant.BonusNumberTestConstant.BONUS_NUMBER;
import static lotto.constant.LottoTestConstant.FIFTH_RANK_LOTTO_NUMBERS;
import static lotto.constant.LottoTestConstant.FIRST_RANK_LOTTO_NUMBERS;
import static lotto.constant.LottoTestConstant.FOURTH_RANK_LOTTO_NUMBERS;
import static lotto.constant.LottoTestConstant.NO_RANK_LOTTO_NUMBERS;
import static lotto.constant.LottoTestConstant.SECOND_RANK_LOTTO_NUMBERS;
import static lotto.constant.LottoTestConstant.THIRD_RANK_LOTTO_NUMBERS;
import static lotto.constant.WinningNumberTestConstant.WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningDetailTest {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final long TOTAL_PROFIT = 4_033_060_000L;
    private static final WinningNumbers WINNING_NUMBER = new WinningNumbers(WINNING_NUMBERS,
            Integer.parseInt(BONUS_NUMBER));
    private static final List<Lotto> LOTTOS = new ArrayList<>();

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

    @DisplayName("당첨된 로또 개수에 따른 총 수익을 구한다")
    @Test
    void totalProfitTest() {
        WinningDetail winningDetail = new WinningDetail(LOTTOS, WINNING_NUMBER);
        long totalProfit = winningDetail.totalProfit();
        assertThat(totalProfit).isEqualTo(TOTAL_PROFIT);
    }
}