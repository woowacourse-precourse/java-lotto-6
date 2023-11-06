package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @DisplayName("Rank는 일치하는 번호의 갯수와 상금을 가진다")
    @ParameterizedTest
    @CsvSource({
            "0, false, NOTHING",
            "1, false, NOTHING",
            "2, false, NOTHING",
            "3, false, FIFTH",
            "4, false, FOURTH",
            "5, false, THIRD",
            "5, true,  SECOND",
            "6, false, FIRST",
    })
    void 순위_검증_테스트(int equalCount, boolean hasBonus, Rank expected) {
        Rank rank = Rank.of(equalCount,hasBonus);
        assertThat(rank).isEqualTo(expected);
    }
}