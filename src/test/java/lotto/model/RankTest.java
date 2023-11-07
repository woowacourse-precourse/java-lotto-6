package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"FIFTH, 3, true", "FOURTH, 4, true", "THIRD, 5, false", "SECOND, 5, true", "FIRST, 6, false",
            "MISS, 0, true"})
    void test(Rank rank, int count, boolean contain) {
        assertThat(Rank.valueOf(count, contain)).isEqualTo(rank);
    }
}