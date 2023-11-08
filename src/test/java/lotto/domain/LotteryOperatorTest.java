package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.utils.FixedRandom;
import lotto.domain.utils.TestLotteryRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Unit] LotteryOperator에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LotteryOperatorTest {
    private static Collection<? extends LotteryRanking> rankings = List.of(TestLotteryRanking.values());

    @Test
    void constructor_lotteryPrice가_0보다_작거나_같으면_예외를_발생시킨다() {

        assertThatThrownBy(() -> new LotteryOperator(new LotteryRound(1), rankings, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void draw_호출_전후의_round는_다르다() {
        LotteryRound previousRound = new LotteryRound(1);
        LotteryOperator operator = new LotteryOperator(previousRound, rankings, 1000);
        operator.draw(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(operator.currentRound())
                .isNotEqualTo(previousRound);
    }


    @Nested
    @DisplayName("LotteryOperator.getResult에 관한 테스트")
    class getResultTest {
        LotteryOperator operator = new LotteryOperator(new LotteryRound(1), rankings, 1000);

        @Test
        void getResult_round가_목록에_없으면_빈_Result객체를_반환한다() {
            assertThat(operator.getResult(PurchasedLottery.createLottery(new LotteryRound(2), new FixedRandom())))
                    .isEqualTo(LotteryResults.emptyResults(rankings));
        }

        @ParameterizedTest
        @MethodSource
        void getResult_정확한_결과를_반환한다(List<Integer> winningNumbers, int bonusNumber, LotteryResults expected) {
            LotteryRound currentRound = operator.currentRound();
            operator.draw(winningNumbers, bonusNumber);
            PurchasedLottery givenLottery = new PurchasedLottery(currentRound, new Lotto(List.of(1, 2, 3, 4, 5, 6)));

            assertThat(operator.getResult(givenLottery))
                    .isEqualTo(expected);
        }

        private static Stream<Arguments> getResult_정확한_결과를_반환한다() {
            return Stream.of(
                    arguments(List.of(1, 2, 3, 4, 5, 6), 7,
                            new LotteryResults(TestLotteryRanking.FIRST, 1, rankings)
                    ), arguments(List.of(1, 2, 3, 4, 5, 7), 6,
                            new LotteryResults(TestLotteryRanking.SECOND, 1, rankings)
                    ), arguments(List.of(1, 2, 3, 4, 5, 8), 9,
                            new LotteryResults(TestLotteryRanking.THIRD, 1, rankings)
                    ), arguments(List.of(1, 2, 3, 4, 8, 9), 10,
                            new LotteryResults(TestLotteryRanking.FORTH, 1, rankings)
                    ), arguments(List.of(1, 2, 3, 8, 9, 10), 11,
                            new LotteryResults(TestLotteryRanking.FIFTH, 1, rankings)
                    ), arguments(List.of(1, 2, 8, 9, 10, 11), 12,
                            new LotteryResults(TestLotteryRanking.LAST_PLACE, 1, rankings)
                    )
            );
        }
    }
}
