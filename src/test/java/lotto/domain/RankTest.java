package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {
    @ParameterizedTest
    @CsvSource({
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

    @ParameterizedTest
    @ValueSource(ints = {-1, 7, 8})
    @DisplayName("당첨 조건에 없는 매칭 개수일 경우 예외가 발생합니다.")
    void findRankByWrongMatchCount(int matchCount) {
        assertThatThrownBy(() -> Rank.find(matchCount, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5000",
            "2, 10000",
            "3, 15000",
            "4, 20000"
    })
    @DisplayName("5등 당첨 횟수만큼의 상금을 계산한다.")
    void calculateReward(int number, int expected) {
        int reward = Rank.FIVE.calculateReward(number);
        assertThat(reward).isEqualTo(expected);
    }
}
