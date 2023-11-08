package lotto.domain;

import lotto.constants.LottoRankConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @DisplayName("1등부터 5등까지 결과를 출력할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "4, true, FOURTH",
            "3, false, FIFTH",
            "3, true, FIFTH",
            "2, false, NONE",
            "1, true, NONE"
    })
    void lottoRankTest(int hitCount, boolean bonusMatch, LottoRankConstants expected) {
        //given & when
        LottoRankConstants result = LottoRankConstants.valueOf(hitCount, bonusMatch);

        //then
        assertThat(result).isEqualTo(expected);
    }
}