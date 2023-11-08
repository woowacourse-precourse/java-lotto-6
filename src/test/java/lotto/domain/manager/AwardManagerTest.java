package lotto.domain.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import lotto.domain.*;
import lotto.system.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class AwardManagerTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("makeAwards 테스트")
    class MakeAwards {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 당첨로또와_같은_값_개수를_리스트로_잘_반환하는지_테스트(List<Award> expected, int money, List<Integer> winning, int bonus) {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {

                        int lottoNum = money / Constant.MONEY_UNIT;
                        UserLotto userLotto = new UserLotto(lottoNum);
                        WinningLotto winningLotto = new WinningLotto(new Lotto(winning));
                        BonusNumber bonusNumber = new BonusNumber(bonus);

                        assertThat(AwardManager.makeAwards(winningLotto, userLotto, bonusNumber)).isEqualTo(expected);
                    },
                    List.of(1, 2, 3, 4, 5, 6)
            );
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of(Award.ZERO), "1000", List.of(7, 8, 9, 10, 11, 12), "13"),
                    Arguments.of(List.of(Award.ONE), "1000", List.of(4, 7, 8, 9, 10, 11), "12"),
                    Arguments.of(List.of(Award.TWO), "1000", List.of(1, 2, 7, 8, 9, 10), "11"),
                    Arguments.of(List.of(Award.THREE), "1000", List.of(1, 2, 3, 7, 8, 9), "10"),
                    Arguments.of(List.of(Award.FOUR), "1000", List.of(1, 2, 3, 4, 7, 8), "9"),
                    Arguments.of(List.of(Award.FIVE), "1000", List.of(1, 2, 3, 4, 5, 7), "8"),
                    Arguments.of(List.of(Award.FIVE_BONUS), "1000", List.of(1, 2, 3, 4, 5, 8), "6"),
                    Arguments.of(List.of(Award.SIX), "1000", List.of(1, 2, 3, 4, 5, 6), "7")

            );
        }
    }
}