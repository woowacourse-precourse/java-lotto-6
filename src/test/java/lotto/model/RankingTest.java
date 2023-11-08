package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingTest {
    @DisplayName("당첨번호와 동일한 수의 개수와 보너스 번호의 포함 여부로 등수 정하기")
    @ParameterizedTest
    @CsvSource({"2, false, FAIL", "3, false, FIFTH", "3, true, FIFTH",
            "4, false, FOURTH", "5, false, THIRD", "5, true, SECOND",
            "6, false, FIRST"})
    void getRankingTest(int correct, boolean isBonus, Ranking expected) {
        // given
        Ranking ranking = Ranking.of(correct, isBonus);
        // then
        Assertions.assertThat(ranking.name()).isEqualTo(expected.name());
    }

    @DisplayName("profit을 반환")
    @Test
    void getProfitTest() {
        // given
        Ranking ranking = Ranking.of(4, false);
        // then
        Assertions.assertThat(ranking.getProfit()).isEqualTo(50000);
    }

    @DisplayName("condition을 반환")
    @Test
    void getConditionTest() {
        // given
        Ranking ranking = Ranking.of(4, false);
        // then
        Assertions.assertThat(ranking.getCondition()).isEqualTo("4개 일치 (50,000원) - ");
    }

}