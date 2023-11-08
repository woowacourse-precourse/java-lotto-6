package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.model.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningCalculationMachineTest {

    LottoWinningCalculationMachine calculationMachine = new LottoWinningCalculationMachine();

    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    WinningLotto winningLotto = new WinningLotto(lotto, 7);

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
        int actualCount = calculationMachine.calculateWinningNumber(oneLotto, winningLotto);
        assertThat(actualCount).isEqualTo(expectedCount);
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
        int actualCount = calculationMachine.calculateBonusNumber(oneLotto, winningLotto);
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 0, 5", "4, 0, 4", "5, 0, 3", "5, 1, 2", "6, 0, 1"})
    @DisplayName("일치 개수 계산 테스트")
    void 일치_개수_계산_테스트(int correctWinningNumber, int correctBonusNumber, int place) {
        WinningStatistics winningStatistics = new WinningStatistics();
        calculationMachine.calculatePlace(winningStatistics, correctWinningNumber, correctBonusNumber);

        if (place == 1) {
            assertThat(winningStatistics.getFirstPlace()).isEqualTo(1);
        } else if (place == 2) {
            assertThat(winningStatistics.getSecondPlace()).isEqualTo(1);
        } else if (place == 3) {
            assertThat(winningStatistics.getThirdPlace()).isEqualTo(1);
        } else if (place == 4) {
            assertThat(winningStatistics.getFourthPlace()).isEqualTo(1);
        } else if (place == 5) {
            assertThat(winningStatistics.getFifthPlace()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void 수익률_계산_테스트() {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.addFifthPlace();
        calculationMachine.calculateWinningRate(winningStatistics, 8);
        assertThat(winningStatistics.getWinningRate()).isEqualTo(62.5);
    }

    @Test
    @DisplayName("당첨 통계 계산 테스트")
    void 당첨_통계_계산_테스트() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));

        WinningStatistics winningStatistics = calculationMachine.calculateWinningStatistics(lottos, winningLotto);
        assertThat(winningStatistics.getWinningRate()).isEqualTo(62.5);
        assertThat(winningStatistics.getFifthPlace()).isEqualTo(1);
    }

}