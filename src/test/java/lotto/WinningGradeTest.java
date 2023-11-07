package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningGradeTest {

    @Test
    @DisplayName("로또 일치 개수가 2개 이하면 아무런 상금도 받지 못하는 당첨 등급을 반환한다.")
    void getWinningType_LessThanMinimumMatchCount_NONE_GRADEWinningType() {
        // Given
        int matchingCount = 2;
        boolean matchedBonusNumber = true;

        // When
        WinningGrade winningGrade = WinningGrade.getWinningType(matchingCount, matchedBonusNumber);

        // Then
        assertThat(winningGrade).isEqualTo(WinningGrade.NONE_GRADE);
    }

    @Test
    @DisplayName("로또 일치 개수가 5개며 보너스 번호에 일치하면 2등을 반환한다.")
    void getWinningType_FiveMatchCountAndMatchBonusNumber_SecondWinningType() {
        // Given
        int matchingCount = 5;
        boolean matchedBonusNumber = true;

        // When
        WinningGrade winningGrade = WinningGrade.getWinningType(matchingCount, matchedBonusNumber);

        // Then
        assertThat(winningGrade).isEqualTo(WinningGrade.SECOND_GRADE);
    }

    @Test
    @DisplayName("로또 일치 개수가 5개며 보너스 번호와 일치하지 않으면 3등을 반환한다.")
    void getWinningType_FiveMatchCountAndNotMatchBonusNumber_ThirdWinningType() {
        // Given
        int matchingCount = 5;
        boolean matchedBonusNumber = false;

        // When
        WinningGrade winningGrade = WinningGrade.getWinningType(matchingCount, matchedBonusNumber);

        // Then
        assertThat(winningGrade).isEqualTo(WinningGrade.THIRD_GRADE);
    }

}