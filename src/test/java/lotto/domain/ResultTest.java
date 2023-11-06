package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Map;
import java.util.stream.Stream;
import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @DisplayName("수익률을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("rankCountProvider")
    void calculateRateToReturn(Map<Rank, Long> rankCount, float answer) {
        // given
        Result result = Result.from(rankCount);

        // when
        float rateToReturn = result.calculateRateToReturn();

        // then
        assertThat(Math.round(rateToReturn * 10) / 10.0)
                .isEqualTo(Math.round(answer * 10) / 10.0);

    }

    public static Stream<Arguments> rankCountProvider() {
        return Stream.of(
                arguments(Map.of(Rank.FIRST, 1L,
                        Rank.SECOND, 1L,
                        Rank.THIRD, 1L,
                        Rank.FOURTH, 1L,
                        Rank.FIFTH, 1L,
                        Rank.NONE, 1L), (float) 2_031_555_000 / 6000 * 100),
                arguments(Map.of(Rank.FIRST, 0L,
                        Rank.SECOND, 1L,
                        Rank.THIRD, 1L,
                        Rank.FOURTH, 1L,
                        Rank.FIFTH, 1L,
                        Rank.NONE, 2L), (float) 31_555_000 / 6000 * 100),
                arguments(Map.of(Rank.FIRST, 0L,
                        Rank.SECOND, 0L,
                        Rank.THIRD, 1L,
                        Rank.FOURTH, 1L,
                        Rank.FIFTH, 1L,
                        Rank.NONE, 3L), (float) 1_555_000 / 6000 * 100),
                arguments(Map.of(Rank.FIRST, 0L,
                        Rank.SECOND, 0L,
                        Rank.THIRD, 0L,
                        Rank.FOURTH, 0L,
                        Rank.FIFTH, 3L,
                        Rank.NONE, 7L), (float) 15_000 / 10000 * 100)
        );
    }

    @DisplayName("getter의 불변성이 보장된다.")
    @ParameterizedTest
    @MethodSource("rankCountProvider")
    void getRankCount(Map<Rank, Long> rankCount) {
        // given
        Result result = Result.from(rankCount);

        // when
        Map<Rank, Long> getRankCount = result.getRankCount();

        // then
        assertThatThrownBy(() -> getRankCount.put(Rank.FIRST, 10L))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}