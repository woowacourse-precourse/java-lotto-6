package lotto.domain;

import static lotto.domain.MatchingCase.NEW_GAME;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoResultTest {
    @DisplayName("recordMatchingCaseResults은 비교 결과들을 당첨 통계에 반영한다")
    @ParameterizedTest
    @CsvSource(value = {"3, false, THREE_MATCHING", "6, false, SIX_MATCHING", "5, true, FIVE_MATCHING_WITH_BONUS"})
    void check_setResult(int winningCount, boolean bonusMatching, MatchingCase matchingCase) {
        // given
        NEW_GAME.initMatchingCase();
        LottoResult lottoResult = LottoResult.of(winningCount, bonusMatching);
        // when
        lottoResult.recordMatchingCaseResults();
        // then
        assertThat(matchingCase.getWinningCount()).isEqualTo(1);
    }
}
