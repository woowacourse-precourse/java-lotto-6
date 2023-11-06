package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

class RanksTest {
    private List<Rank> ranks;
    private Ranks test;

    @BeforeEach
    void init() {
        ranks = new ArrayList<>();
        ranks.add(FIFTH);
        ranks.add(FIFTH);
        ranks.add(FIFTH);
        ranks.add(FOURTH);
        ranks.add(FOURTH);
        ranks.add(THIRD);
        ranks.add(SECOND);
        test = new Ranks(ranks);
    }

    @DisplayName("5등의 갯수를 정확히 카운트한다.")
    @Test
    void countRankFifth() {
        Map<Integer, Integer> result = test.countRankNum();

        assertThat(result.getOrDefault(0, 0)).isEqualTo(3);
    }

    @DisplayName("4등의 갯수를 정확히 카운트한다.")
    @Test
    void countRankFourth() {
        Map<Integer, Integer> result = test.countRankNum();

        assertThat(result.getOrDefault(1, 0)).isEqualTo(2);
    }

    @DisplayName("3등의 갯수를 정확히 카운트한다.")
    @Test
    void countRankThird() {
        Map<Integer, Integer> result = test.countRankNum();

        assertThat(result.getOrDefault(2, 0)).isEqualTo(1);
    }

    @DisplayName("2등의 갯수를 정확히 카운트한다.")
    @Test
    void countRankSecond() {
        Map<Integer, Integer> result = test.countRankNum();

        assertThat(result.getOrDefault(3, 0)).isEqualTo(1);
    }

    @DisplayName("1등의 갯수를 정확히 카운트한다.")
    @Test
    void countRankFirst() {
        Map<Integer, Integer> result = test.countRankNum();

        assertThat(result.getOrDefault(4, 0)).isEqualTo(0);
    }
}