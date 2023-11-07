package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("1등 테스트")
    @Test
    void first() {
        Rank rank = Rank.FIRST;

        boolean result = rank.calculateRank(6, false);

        assertThat(result).isTrue();
    }

    @DisplayName("2등 테스트")
    @Test
    void second() {
        Rank rank = Rank.SECOND;

        boolean result = rank.calculateRank(5, true);

        assertThat(result).isTrue();
    }

    @DisplayName("3등 테스트")
    @Test
    void third() {
        Rank rank = Rank.THIRD;

        boolean result = rank.calculateRank(5, false);

        assertThat(result).isTrue();
    }

    @DisplayName("4등 테스트(보너스 맞음)")
    @Test
    void fourthCase1() {
        Rank rank = Rank.FOURTH;

        boolean result = rank.calculateRank(4, true);

        assertThat(result).isTrue();
    }

    @DisplayName("4등 테스트(보너스 틀림)")
    @Test
    void fourthCase2() {
        Rank rank = Rank.FOURTH;

        boolean result = rank.calculateRank(4, false);

        assertThat(result).isTrue();
    }

    @DisplayName("5등 테스트 (보너스 맞음)")
    @Test
    void fifthCase1() {
        Rank rank = Rank.FIFTH;

        boolean result = rank.calculateRank(3, true);

        assertThat(result).isTrue();
    }

    @DisplayName("5등 테스트 (보너스 틀림)")
    @Test
    void fifthCase2() {
        Rank rank = Rank.FIFTH;

        boolean result = rank.calculateRank(3, false);

        assertThat(result).isTrue();
    }

    @DisplayName("등수 없음(보너스 맞음)")
    @Test
    void noneCase1() {
        Rank rank = Rank.NONE;

        boolean result = rank.calculateRank(2, true);

        assertThat(result).isTrue();
    }

    @DisplayName("등수 없음(보너스 틀림)")
    @Test
    void noneCase2() {
        Rank rank = Rank.NONE;

        boolean result = rank.calculateRank(2, false);

        assertThat(result).isTrue();
    }
}
