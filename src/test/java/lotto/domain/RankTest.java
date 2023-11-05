package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("3개의 번호가 일치해 5등임을 알려준다.")
    void fifth_prize() {
        // given
        int countOfMatch = 3;
        boolean containsBonus = false;

        // when
        Rank result = Rank.valueOf(countOfMatch, containsBonus);

        // then
        assertThat(result).isEqualTo(FIFTH);
    }

    @Test
    @DisplayName("4개의 번호가 일치해 4등임을 알려준다.")
    void fourth_prize() {
        // given
        int countOfMatch = 4;
        boolean containsBonus = false;

        // when
        Rank result = Rank.valueOf(countOfMatch, containsBonus);

        // then
        assertThat(result).isEqualTo(FOURTH);
    }

    @Test
    @DisplayName("5개의 번호가 일치해 3등임을 알려준다.")
    void third_prize() {
        // given
        int countOfMatch = 5;
        boolean containsBonus = false;

        // when
        Rank result = Rank.valueOf(countOfMatch, containsBonus);

        // then
        assertThat(result).isEqualTo(THIRD);
    }

    @Test
    @DisplayName("5개의 번호와 보너스 번호가 일치해 2등임을 알려준다.")
    void second_prize() {
        // given
        int countOfMatch = 5;
        boolean containsBonus = true;

        // when
        Rank result = Rank.valueOf(countOfMatch, containsBonus);

        // then
        assertThat(result).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("6개의 번호가 일치해 1등임을 알려준다.")
    void first_prize() {
        // given
        int countOfMatch = 6;
        boolean containsBonus = false;

        // when
        Rank result = Rank.valueOf(countOfMatch, containsBonus);

        // then
        assertThat(result).isEqualTo(FIRST);
    }
}
