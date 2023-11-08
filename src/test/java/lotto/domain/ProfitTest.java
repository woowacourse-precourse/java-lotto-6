package lotto.domain;

import static lotto.domain.MatchingCase.NEW_GAME;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitTest {
    @DisplayName("getProfit은 수익률을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, false, 50.0", "4, false, 500.0", "5, false, 15000.0", "5, true, 300000.0",
            "6, false, 20000000.0"})
    void check_getProfit(int winningCount, boolean bonusMatching, double expectedProfit) {
        // given
        NEW_GAME.initMatchingCase();
        LottoResult lottoResult = LottoResult.of(winningCount, bonusMatching);
        lottoResult.recordMatchingCaseResults();
        // when
        Profit profit = Profit.from(NEW_GAME.getResult(), 10000);
        // then
        assertThat(profit.getProfit()).isEqualTo(expectedProfit);
    }

    @DisplayName("getProfit은 여러 로또 결과를 합산한 수익률을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, false, 4, false, 550.0", "5, false, 5, true, 315000.0"})
    void check_getProfit_multi(int winningCount1, boolean bonusMatching1, int winningCount2, boolean bonusMatching2,
                               double expectedProfit) {
        // given
        NEW_GAME.initMatchingCase();
        LottoResult lottoResult1 = LottoResult.of(winningCount1, bonusMatching1);
        lottoResult1.recordMatchingCaseResults();
        LottoResult lottoResult2 = LottoResult.of(winningCount2, bonusMatching2);
        lottoResult2.recordMatchingCaseResults();
        // when
        Profit profit = Profit.from(NEW_GAME.getResult(), 10000);
        // then
        assertThat(profit.getProfit()).isEqualTo(expectedProfit);
    }
}
