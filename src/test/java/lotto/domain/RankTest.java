package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void Rank_객체_생성() {
        assertThat(Rank.create())
                .isInstanceOf(Rank.class);
    }

    @Test
    void fifth_기준을_충족하면_count를_한다() {
        Rank rank = Rank.create();
        rank.updateRank(3, false);
        assertThat(rank.toDTO().fifthRankCount())
                .isEqualTo(1);
    }

    @Test
    void fourth_기준을_충족하면_count를_한다() {
        Rank rank = Rank.create();
        rank.updateRank(4, false);
        assertThat(rank.toDTO().fourthRankCount())
                .isEqualTo(1);
    }

    @Test
    void third_기준을_충족하면_count를_한다() {
        Rank rank = Rank.create();
        rank.updateRank(5, false);
        assertThat(rank.toDTO().thirdRankCount())
                .isEqualTo(1);
    }

    @Test
    void second_기준을_충족하면_count를_한다() {
        Rank rank = Rank.create();
        rank.updateRank(5, true);
        assertThat(rank.toDTO().secondRankCount())
                .isEqualTo(1);
    }

    @Test
    void first_기준을_충족하면_count를_한다() {
        Rank rank = Rank.create();
        rank.updateRank(6, false);
        assertThat(rank.toDTO().firstRankCount())
                .isEqualTo(1);
    }
}
