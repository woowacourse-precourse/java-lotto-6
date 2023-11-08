package lotto;

import static lotto.utils.constants.LottoConstants.MATCH_FIVE_AND_BONUS_PRICE;
import static lotto.utils.constants.LottoConstants.MATCH_FIVE_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_FOUR_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_FOUR_PRICE;
import static lotto.utils.constants.LottoConstants.MATCH_SIX_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_THREE_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_THREE_PRICE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.result.MatchResult;
import lotto.domain.result.WinningResult;
import lotto.exception.LottoException;
import lotto.model.calculator.MatchCalculator;
import lotto.model.calculator.ProfitCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateTest {
    @Test
    @DisplayName("당첨 번호 갯수 계산 테스트.")
    void calculateMatches_GivenLottosAndWinningResult_ReturnsMatchResult() {

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningResult winningResult = new WinningResult(winningNumbers, bonusNumber);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 10, 20, 30));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4);

        MatchResult matchResult = MatchCalculator.calculateMatches(lottos, winningResult);

        assertNotNull(matchResult);
        Map<Integer, Integer> matchCounts = matchResult.getMatchCounts();
        assertEquals(1, matchCounts.getOrDefault(3, 0));
        assertEquals(0, matchCounts.getOrDefault(4, 0));
        assertEquals(1, matchCounts.getOrDefault(5, 0));
        assertEquals(1, matchCounts.getOrDefault(6, 0));
        assertEquals(1, matchResult.getBonusMatchCount());
    }

    @Test
    @DisplayName("당첨 수익 계산 테스트.")
    void calculateProfitPrice_WithMatchResult_ReturnsTotalProfit() {
        MatchResult matchResult = mock(MatchResult.class);

        when(matchResult.getMatchCounts(MATCH_THREE_COUNT)).thenReturn(1);
        when(matchResult.getMatchCounts(MATCH_FOUR_COUNT)).thenReturn(2);
        when(matchResult.getMatchCounts(MATCH_FIVE_COUNT)).thenReturn(1);
        when(matchResult.getMatchCounts(MATCH_SIX_COUNT)).thenReturn(0);
        when(matchResult.getBonusMatchCount()).thenReturn(1);

        int totalProfit = ProfitCalculator.calculateProfitPrice(matchResult);

        int expectedProfit = MATCH_THREE_PRICE +
                2 * MATCH_FOUR_PRICE +
                MATCH_FIVE_AND_BONUS_PRICE;

        assertEquals(expectedProfit, totalProfit);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfitPercentage_WithTotalProfitAndPurchasePrice_ReturnsProfitPercentage() {
        int[][] testCases = {
                {50000, 5000, 1000},
                {30000, 1500, 2000},
        };

        for (int[] testCase : testCases) {
            int totalProfit = testCase[0];
            int purchasePrice = testCase[1];
            float expectedProfitPercentage = testCase[2];

            float profitPercentage = ProfitCalculator.calculateProfitPercentage(totalProfit, purchasePrice);
            assertEquals(expectedProfitPercentage, profitPercentage);

        }
    }

    @Test
    @DisplayName("수익률 계산 시 분모가 0이면 예외를 발생시킨다.")
    void calculateProfitPercentage_WhenPurchasePriceIsZero_ThrowsException() {
        int totalProfit = 1500;
        int purchasePrice = 0;

        assertThrows(LottoException.class, () -> ProfitCalculator.calculateProfitPercentage(totalProfit, purchasePrice));
    }
}
