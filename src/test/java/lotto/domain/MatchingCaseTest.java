package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MatchingCaseTest {
    @DisplayName("recordResult는 일치 숫자와 보너스 번호 일치 여부에 따라 각 일치 케이스의 당첨 횟수를 증가시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"THREE_MATCHING, 3, false", "FOUR_MATCHING, 4, false", "FIVE_MATCHING_WITH_BONUS, 5, true"})
    void check_recordResult(MatchingCase matchingCase, int matchingCount, boolean bonusMatching) {
        // given
        MatchingCase.NEW_GAME.initMatchingCase();
        // when
        matchingCase.recordResult(matchingCount, bonusMatching);
        matchingCase.recordResult(matchingCount, bonusMatching);
        // then
        assertThat(matchingCase.getWinningCount()).isEqualTo(2);
    }
    @DisplayName("initMatchingCase는 각 일치 케이스의 당첨 횟수를 초기화한다.")
    @ParameterizedTest
    @CsvSource(value = {"THREE_MATCHING, 3, false", "FOUR_MATCHING, 4, false", "FIVE_MATCHING_WITH_BONUS, 5, true"})
    void check_init(MatchingCase matchingCase, int matchingCount, boolean bonusMatching) {
        // given
        matchingCase.recordResult(matchingCount, bonusMatching);
        matchingCase.recordResult(matchingCount, bonusMatching);
        // when
        matchingCase.initMatchingCase();
        // then
        assertThat(matchingCase.getWinningCount()).isEqualTo(0);
    }
}
