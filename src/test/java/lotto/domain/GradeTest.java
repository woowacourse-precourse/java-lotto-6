package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class GradeTest {
    @ParameterizedTest
    @CsvSource({
            "6, 0, FIRST",
            "5, 1, SECOND",
            "5, 0, THIRD",
            "4, 0, FOURTH",
            "3, 0, FIFTH",
    })
    @DisplayName("당첨 번호, 보너스 번호 일치 여부에 따른 등수를 올바르게 판별한다.")
    void findingRank(int matchingNumbers, int matchingBonus, String expectedGrade) {
        assertThat(Grade.findGrade(matchingNumbers, matchingBonus).name()).isEqualTo(expectedGrade);
    }
}