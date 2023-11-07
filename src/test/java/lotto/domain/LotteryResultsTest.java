package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import lotto.CustomLotteryRanking;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Unit] LotteryResults에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LotteryResultsTest {

    private static int MAX = Integer.MAX_VALUE / 2;

    private static Collection<? extends LotteryRanking> rankings = List.of(TestLotteryRanking.values());

    @Test
    void constructor_matches가_0보다_작으면_예외를_발생한다() {
        assertThatThrownBy(() ->
                new LotteryResults(TestLotteryRanking.FIRST, -1, rankings)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_matches가_MAX값_이상이면_예외를_발생한다() {
        assertThatThrownBy(() -> new LotteryResults(TestLotteryRanking.FIRST, MAX + 1, rankings)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void applyResults_더해서_MAX값_이상인_값을_가지게_되면_예외를_발생한다() {
        LotteryResults results1 = new LotteryResults(TestLotteryRanking.FIRST, MAX, rankings);
        LotteryResults results2 = new LotteryResults(TestLotteryRanking.FIRST, 1, rankings);

        assertThatThrownBy(() -> results1.applyResults(results2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void applyResults_빈_결과집합끼리_더하면_빈_결과집합과_동등하다() {
        LotteryResults results1 = LotteryResults.emptyResults(rankings);
        LotteryResults results2 = LotteryResults.emptyResults(rankings);

        assertThat(results1.applyResults(results2))
                .isEqualTo(LotteryResults.emptyResults(rankings));
    }

    @Test
    void applyResults_빈_결과집합을_더하면_처음_결과집합과_동등하다() {
        LotteryResults results = new LotteryResults(TestLotteryRanking.FIRST, 100, rankings);

        assertThat(results.applyResults(LotteryResults.emptyResults(rankings)))
                .isEqualTo(new LotteryResults(TestLotteryRanking.FIRST, 100, rankings));
    }

    @ParameterizedTest
    @MethodSource
    void getTotalAmount_값을_제대로_계산한다(LotteryResults r1, LotteryResults r2, long expected) {
        LotteryResults results = new LotteryResults(TestLotteryRanking.FIRST, 1, rankings);
        results.applyResults(new LotteryResults(TestLotteryRanking.SECOND, 1, rankings));

        assertThat(results.getTotalAmount())
                .isEqualTo(2030000000);
    }

    private static Stream<Arguments> getTotalAmount_값을_제대로_계산한다() {
        return Stream.of(
                arguments(
                        new LotteryResults(TestLotteryRanking.FIRST, 1, rankings),
                        new LotteryResults(TestLotteryRanking.SECOND, 1, rankings),
                        2030000000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.SECOND, 1, rankings),
                        new LotteryResults(TestLotteryRanking.THIRD, 2, rankings),
                        33000000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.THIRD, 2, rankings),
                        new LotteryResults(TestLotteryRanking.FORTH, 3, rankings),
                        3150000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.FORTH, 3, rankings),
                        new LotteryResults(TestLotteryRanking.FIFTH, 4, rankings),
                        170000
                ),
                arguments(
                        new LotteryResults(TestLotteryRanking.FIFTH, 4, rankings),
                        new LotteryResults(TestLotteryRanking.LAST_PLACE, 5, rankings),
                        20000
                )
        );
    }
}
