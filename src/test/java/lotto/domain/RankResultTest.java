package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankResultTest {

    @DisplayName("당첨 내역을 가져온다.")
    @Test
    void getRankTest() {
        Map<RankPrize, Integer> rank = new EnumMap<>(RankPrize.class);
        Arrays.stream(RankPrize.values())
                .forEach(rankPrize -> rank.put(rankPrize, 0));
        RankResult rankResult = new RankResult(rank);
        assertThatCode(rankResult::getRankResult)
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 등수에 따른 수익률을 반환한다.")
    @ParameterizedTest
    @MethodSource("provideCalculateReturnTestArguments")
    void calculateReturnTest(int purchaseAmount, RankPrize rankPrize, int matchCounts, double expectedTotalReturn) {
        Map<RankPrize, Integer> rank = new EnumMap<>(RankPrize.class);
        Arrays.stream(RankPrize.values())
                .forEach(r -> rank.put(r, 0));
        rank.put(rankPrize, matchCounts);
        RankResult rankResult = new RankResult(rank);
        assertThat(rankResult.calculateReturn(purchaseAmount)).isEqualTo(expectedTotalReturn);
    }

    static Stream<Arguments> provideCalculateReturnTestArguments() {
        return Stream.of(
                arguments(1000, RankPrize.FIRST_PLACE, 1, 200000000.0),
                arguments(1000, RankPrize.SECOND_PLACE, 1, 3000000.0),
                arguments(1000, RankPrize.THIRD_PLACE, 1, 150000.0),
                arguments(1000, RankPrize.FOURTH_PLACE, 1, 5000.0),
                arguments(1000, RankPrize.FIFTH_PLACE, 1, 500.0)
        );
    }
}
