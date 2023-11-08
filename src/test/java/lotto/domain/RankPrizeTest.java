package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankPrizeTest {

    @DisplayName("3개 이상 맞출시 당첨 번호와 일치하는 갯수, 보너스 번호 당첨 유무로 등수를 결정한다.")
    @ParameterizedTest
    @MethodSource("provideDetermineRankPrizeInRankTest")
    void determineRankPrizeInRankTest(int matchCounts, boolean isBonusMatched, RankPrize expectedRankPrize) {
        RankPrize rankPrize = RankPrize.determineRankPrize(matchCounts, isBonusMatched);
        assertThat(rankPrize.getMatchCounts()).isEqualTo(matchCounts);
        assertThat(rankPrize).isEqualTo(expectedRankPrize);
    }

    static Stream<Arguments> provideDetermineRankPrizeInRankTest() {
        return Stream.of(
                arguments(3, false, RankPrize.FIFTH_PLACE),
                arguments(3, true, RankPrize.FIFTH_PLACE),
                arguments(4, false, RankPrize.FOURTH_PLACE),
                arguments(4, true, RankPrize.FOURTH_PLACE),
                arguments(5, false, RankPrize.THIRD_PLACE),
                arguments(5, true, RankPrize.SECOND_PLACE),
                arguments(6, false, RankPrize.FIRST_PLACE)
        );
    }

    @DisplayName("3개 이하로 맞출시 null을 반환한다.")
    @ParameterizedTest
    @MethodSource("provideDetermineRankPrizeOutOfRankTest")
    void determineRankPrizeOutOfRankTest(int matchCounts, boolean isBonusMatched) {
        RankPrize rankPrize = RankPrize.determineRankPrize(matchCounts, isBonusMatched);
        assertThat(rankPrize).isNull();
    }

    static Stream<Arguments> provideDetermineRankPrizeOutOfRankTest() {
        return Stream.of(
                arguments(1, false),
                arguments(1, true),
                arguments(2, false),
                arguments(2, true)
        );
    }
}
