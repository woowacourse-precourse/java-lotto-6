package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class GradeTest {
    private static final String INVALID_KEY_MESSAGE = "[ERROR] 유효하지 않은 등급 이름입니다.";
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

    @ParameterizedTest
    @CsvSource({"ab", "-", "7"})
    @DisplayName("유효하지 않은 Rank 값이면 예외가 발생한다.")
    void findGradeByInvalidKeyThrowError(String rank) {
        assertThatThrownBy(() -> Grade.findGradeByRank(rank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_KEY_MESSAGE);
    }
}