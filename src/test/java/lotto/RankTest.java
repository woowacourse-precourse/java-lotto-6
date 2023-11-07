package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @DisplayName("Rank는 일치하는 숫자의 개수와 보너스 숫자 일치 여부에 따라 순위를 반환한다.")
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
    void valueOf(int equalCount, boolean hasBonus, Rank expected) {
        Rank rank = Rank.valueOf(equalCount,hasBonus);
        assertThat(rank).isEqualTo(expected);
    }
}