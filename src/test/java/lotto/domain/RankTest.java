package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

    @DisplayName("6개 번호가 모두 일치하면 1등을 반환한다.")
    @Test
    void returnFirstForAllMatches() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void returnSecondForFiveMatchesAndBonus() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 일치하지 않으면 3등을 반환한다.")
    @Test
    void returnThirdForFiveMatchesWithoutBonus() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 번호가 일치하면 4등을 반환한다.")
    @Test
    void returnFourthForFourMatches() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호가 일치하면 5등을 반환한다.")
    @Test
    void returnFifthForThreeMatches() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하 번호가 일치하면 등수가 없음을 반환한다.")
    @Test
    void returnNoneForLessThanThreeMatches() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
        rank = Rank.valueOf(1, false);
        assertThat(rank).isEqualTo(Rank.NONE);
        rank = Rank.valueOf(0, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("일치하는 번호가 있어도 보너스 번호가 일치하지 않으면 다음 등수를 반환한다.")
    @Test
    void returnNextRankForMatchesWithoutBonus() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isNotEqualTo(Rank.SECOND).isEqualTo(Rank.THIRD);
    }
}