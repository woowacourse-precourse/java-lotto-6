package lotto.utils;

import lotto.constant.LotteryRank;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @DisplayName("당첨 등수를 계산하는 테스트")
    @ParameterizedTest
    @MethodSource("generateLotto")
    void calculateLotteryRankTest(Lotto winningLotto, int bonusNumber, Lotto playerLotto, LotteryRank expected) {
        // given
        LottoMachine lottoMachine = new LottoMachine(winningLotto, bonusNumber);

        // when
        LotteryRank result = lottoMachine.calculateLotteryRank(playerLotto);

        // then
        assertThat(result).isEqualTo(expected);
    }


    static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        LotteryRank.FIRST_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        LotteryRank.SECOND_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                        LotteryRank.THIRD_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                        LotteryRank.THIRD_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        LotteryRank.FOURTH_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                        LotteryRank.FOURTH_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                        LotteryRank.FIFTH_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                        LotteryRank.FIFTH_PRIZE
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        LotteryRank.ETC
                )
        );
    }

}