package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankTest {
    @DisplayName("당첨번호 갯수와 보너스 번호 일치 여부에 따라 Rank를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:false:FIFTH", "4:false:FOURTH", "5:false:THIRD", "5:true:SECOND", "6:false:FIRST"}, delimiter = ':')
    void from(int matchCount, boolean matchBonus, Rank expected) {
        assertThat(Rank.from(matchCount, matchBonus)).isEqualTo(expected);
    }

    @DisplayName("각 Rank의 당첨금을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST:2000000000", "SECOND:30000000", "THIRD:1500000", "FOURTH:50000", "FIFTH:5000", "MISS:0"}, delimiter = ':')
    void getWinningMoney(Rank rank, long expected) {
        assertThat(rank.getWinningMoney()).isEqualTo(expected);
    }

    @DisplayName("각 Rank의 일치하는 보너스 번호 여부를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST:false", "SECOND:true", "THIRD:false", "FOURTH:false", "FIFTH:false", "MISS:false"}, delimiter = ':')
    void getMatchBonus(Rank rank, boolean expected) {
        assertThat(rank.getMatchBonus()).isEqualTo(expected);
    }

    @DisplayName("각 Rank의 일치하는 번호 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST:6", "SECOND:5", "THIRD:5", "FOURTH:4", "FIFTH:3", "MISS:0"}, delimiter = ':')
    void matchCount(Rank rank, int expected) {
        assertThat(rank.getMatchCount()).isEqualTo(expected);
    }
}