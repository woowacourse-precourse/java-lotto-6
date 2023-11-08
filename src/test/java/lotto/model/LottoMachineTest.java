package lotto.model;

import lotto.constant.LotteryRank;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @DisplayName("당첨 등수를 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("generateLotto")
    void calculateLotteryRankTest(Lotto winningLotto, int bonusNumber, Lotto playerLotto, LotteryRank playerLotteryRank, boolean expected) {
        // given
        LottoMachine lottoMachine = new LottoMachine(winningLotto, bonusNumber);

        // when
        boolean result = lottoMachine.checkLotteryRank(playerLotto, playerLotteryRank);

        // then
        assertThat(result).isEqualTo(expected);
    }


    // TODO: 테스트 케이스 다시 작성하기 (보너스 포함 여부 로직 변경)
    static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        LotteryRank.FIRST_PRIZE,
                        true
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        LotteryRank.SECOND_PRIZE,
                        true
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                        LotteryRank.THIRD_PRIZE,
                        true
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        LotteryRank.FOURTH_PRIZE,
                        true
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                        LotteryRank.FIFTH_PRIZE,
                        true
                ),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        LotteryRank.ETC,
                        true
                )
        );
    }

}