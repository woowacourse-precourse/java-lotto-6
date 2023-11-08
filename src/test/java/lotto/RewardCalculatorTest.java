package lotto;

import lotto.LottoEnum.Prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardCalculatorTest {
    @ParameterizedTest
    @MethodSource("getRewardTestArguments")
    @DisplayName("getRewardTest")
    public void ggetRewardTest(Prize prize, int answer) {
        RewardCalculator rewardCalculator = new RewardCalculator();

        int result = rewardCalculator.getReward(prize);

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> getRewardTestArguments() {
        return Stream.of(
                Arguments.of(Prize.SECOND, 30000000),
                Arguments.of(Prize.THIRD, 1500000),
                Arguments.of(Prize.FOURTH, 50000),
                Arguments.of(Prize.FIFTH, 5000),
                Arguments.of(Prize.LOSE, 0),
                Arguments.of(Prize.LOSE, 0),
                Arguments.of(Prize.LOSE, 0),
                Arguments.of(Prize.FIFTH, 5000)
        );
    }

    @ParameterizedTest
    @MethodSource("getPrizeResultsTestArguments")
    @DisplayName("getPrizeResultsTest")
    public void getPrizeResultsTest(List<Prize> prizes, int answer) {
        RewardCalculator rewardCalculator = new RewardCalculator();
        int result = rewardCalculator.getTotalReward(prizes);
        ;

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> getPrizeResultsTestArguments() {
        return Stream.of(
                Arguments.of(List.of(Prize.SECOND, Prize.THIRD), 31500000),
                Arguments.of(List.of(Prize.FOURTH, Prize.FIFTH), 55000),
                Arguments.of(List.of(Prize.LOSE, Prize.LOSE), 0),
                Arguments.of(List.of(Prize.LOSE, Prize.FIFTH), 5000)
        );
    }
}
