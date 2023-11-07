package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0, true, NONE",
            "0, false, NONE",
            "3, true, FIVE",
            "3, false, FIVE",
            "4, true, FOUR",
            "4, false, FOUR",
            "5, false, THREE",
            "5, true, TWO",
            "6, true, ONE",
            "6, false, ONE",
    })
    @DisplayName("매칭 개수와 보너스 매칭 여부에 따른 당첨 순위를 구한다.")
    void findRank(int matchCount, boolean hasBonus, Rank expected) {
        Rank rank = Rank.find(matchCount, hasBonus);
        assertThat(rank).isEqualTo(expected);
    }
}
