package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGradeTest {

    @DisplayName("of는 일치하는 개수와 보너스 번호 일치 여부를 받아서, 해당하는 LottoGrade를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, true, FOURTH",
            "4, false, FOURTH",
            "3, true, FIFTH",
            "3, false, FIFTH",
            "2, true, MISS",
            "2, false, MISS",
            "1, true, MISS",
            "1, false, MISS",
            "0, true, MISS",
            "0, false, MISS"
    })
    void ofTest(int matchCount, boolean matchBonus, LottoGrade expected) {
        assertThat(LottoGrade.of(matchCount, matchBonus)).isEqualTo(expected);
    }
}