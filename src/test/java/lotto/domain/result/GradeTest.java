package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradeTest {

    @CsvSource({"6, 1, FIRST",
            "5, 1, SECOND",
            "5, 0, THIRD",
            "4, 1, FOURTH",
            "3, 1, FIFTH",
            "2, 1, NONE"})
    @ParameterizedTest
    void 당첨_순위를_반환한다(int matchCount, int bonusMatchCount, Grade expected) {
        //Act
        Grade actual = Grade.of(matchCount, bonusMatchCount);

        //Assert
        assertThat(actual).isEqualTo(expected);
    }
}