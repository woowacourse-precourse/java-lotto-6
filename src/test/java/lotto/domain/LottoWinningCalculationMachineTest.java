package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningCalculationMachineTest {

    LottoWinningCalculationMachine calculationMachine = new LottoWinningCalculationMachine();

    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    WinningNumber winningNumber = new WinningNumber(lotto, 7);

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(8, 2, 3, 4, 15, 28), 3),
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), 6),
                Arguments.of(Arrays.asList(8, 9, 40, 30, 15, 28), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoData")
    @DisplayName("당첨 번호와 일치 개수 테스트")
    void 당첨번호_일치_개수_테스트(List<Integer> lotto, int expectedCount) {
        Lotto oneLotto = new Lotto(lotto);
        int actualCount = calculationMachine.calculateWinningNumber(oneLotto, winningNumber);
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);
    }

    static Stream<Arguments> generateLottoBonusData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 1),
                Arguments.of(Arrays.asList(8, 2, 3, 4, 15, 28), 0),
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1), 0),
                Arguments.of(Arrays.asList(8, 9, 7, 30, 15, 28), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoBonusData")
    @DisplayName("보너스 번호와 일치 개수 테스트")
    void 보너스번호_일치_개수_테스트(List<Integer> lotto, int expectedCount) {
        Lotto oneLotto = new Lotto(lotto);
        int actualCount = calculationMachine.calculateBonusNumber(oneLotto, winningNumber);
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);
    }

}