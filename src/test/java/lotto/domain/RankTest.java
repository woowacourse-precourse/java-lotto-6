package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("일치하는 숫자 갯수와 당첨 순위 일치하는 객체 반환")
    @ParameterizedTest
    @CsvSource(value = {"_5TH,3,false", "_4TH,4,false", "_3RD,5,false", "_2ND,5,true", "_1ST,6,false"}, delimiter = ',')
    void findByRank(String expected, int correctCount, boolean isBonus) {
        Rank rank = Rank.findByCorrectCountAndIsBonus(correctCount, isBonus);

        Rank result = Rank.valueOf(expected);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("2,3등을 제외하고 나머지는 보너스 숫자가 일치해도 관계 없다")
    @ParameterizedTest
    @CsvSource(value = {"_5TH,3,true", "_4TH,4,true", "_3RD,5,false", "_2ND,5,true", "_1ST,6,false"}, delimiter = ',')
    void findByRank_2nd_and_3rd_Exclude(String expected, int correctCount, boolean isBonus) {
        Rank rank = Rank.findByCorrectCountAndIsBonus(correctCount, isBonus);

        Rank result = Rank.valueOf(expected);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("일치하는 숫자 갯수가 당첨 순위에 없으면 BLANK 0원 값을 얻는다.")
    @ParameterizedTest
    @CsvSource(value = {"BLANK,2,false", "BLANK,1,false", "BLANK,0,false"}, delimiter = ',')
    void findByRank_BLANK(String expected, int correctCount, boolean isBonus) {
        Rank rank = Rank.findByCorrectCountAndIsBonus(correctCount, isBonus);

        Rank result = Rank.valueOf(expected);

        assertThat(rank).isEqualTo(result);
        assertThat(rank.getWinningAmount()).isEqualTo(0L);
    }
}