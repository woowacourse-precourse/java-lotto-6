package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LottoRankingTest {

    @ParameterizedTest
    @CsvSource(value = {"6, false, FIRST", "5, true, SECOND", "5, false, THIRD", "4, true, FOURTH", "3, true, FIFTH"})
    @DisplayName("일치하는 번호의 개수와 보너스 번호 일치 여부에 따라 로또 결과를 알 수 있다.")
    void of(int numberOfMatches, boolean hasBonusNumber, LottoRanking expected) {
        LottoRanking actual = LottoRanking.of(numberOfMatches, hasBonusNumber);
        assertThat(actual).isEqualTo(expected);
    }
}