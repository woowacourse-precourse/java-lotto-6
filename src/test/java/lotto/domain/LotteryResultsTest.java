package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import lotto.CustomLotteryRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Unit] LotteryResults에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LotteryResultsTest {

    private static int MAX = Integer.MAX_VALUE / 2;

    @Test
    void constructor_matches가_0보다_작으면_예외를_발생한다() {
        assertThatThrownBy(() ->
                new LotteryResults(TestLotteryRanking.FIRST, -1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_matches가_MAX값_이상이면_예외를_발생한다() {
        assertThatThrownBy(() -> new LotteryResults(TestLotteryRanking.FIRST, MAX + 1)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void applyResults_MAX값_이상인_값을_가지고_있으면_예외를_발생한다() {
        LotteryResults results1 = new LotteryResults(TestLotteryRanking.FIRST, MAX);
        LotteryResults results2 = new LotteryResults(TestLotteryRanking.FIRST, MAX / 2 + 1);
        LotteryResults results3 = new LotteryResults(TestLotteryRanking.FIRST, MAX / 2);
        results2.applyResults(results3);

        assertThatThrownBy(() -> results1.applyResults(results2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void applyResults_빈_결과집합끼리_더하면_빈_결과집합과_동등하다() {
        LotteryResults results1 = LotteryResults.emptyResults();
        LotteryResults results2 = LotteryResults.emptyResults();

        assertThat(results1.applyResults(results2))
                .isEqualTo(LotteryResults.emptyResults());
    }

    @Test
    void applyResults_빈_결과집합을_더하면_처음_결과집합과_동등하다() {
        LotteryResults results = new LotteryResults(TestLotteryRanking.FIRST, 100);

        assertThat(results.applyResults(LotteryResults.emptyResults()))
                .isEqualTo(new LotteryResults(TestLotteryRanking.FIRST, 100));
    }

    @ParameterizedTest
    @MethodSource
    void getTotalAmount_값을_제대로_계산한다(LotteryResults r1, LotteryResults r2, long expected) {
        LotteryResults results = new LotteryResults(TestLotteryRanking.FIRST, 1);
        results.applyResults(new LotteryResults(TestLotteryRanking.SECOND, 1));

        assertThat(results.getTotalAmount())
                .isEqualTo(2030000000);
    }

    private static Stream<Arguments> getTotalAmount_값을_제대로_계산한다() {
        return Stream.of(
                arguments(
                        new LotteryResults(TestLotteryRanking.FIRST, 1),
                        new LotteryResults(TestLotteryRanking.SECOND, 1),
                        2030000000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.SECOND, 1),
                        new LotteryResults(TestLotteryRanking.THIRD, 2),
                        33000000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.THIRD, 2),
                        new LotteryResults(TestLotteryRanking.FORTH, 3),
                        3150000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.FORTH, 3),
                        new LotteryResults(TestLotteryRanking.FIFTH, 4),
                        170000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.FIFTH, 4),
                        new LotteryResults(TestLotteryRanking.LAST_PLACE, 5),
                        20000
                )
        );
    }
}
