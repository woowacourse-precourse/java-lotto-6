package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    @ParameterizedTest
    @MethodSource("totalPrizesDataProvider")
    void 로또_그룹과_우승자_번호_보너스_번호와_각각_비교하여_전체_상품결과를_계산한다(
            WinningCombination winningCombination, LottoGroup lottoGroup, PrizeSummary expectedPrizeSummary) {
        LottoMachine lottoMachine = LottoMachine.of(lottoGroup, winningCombination);

        PrizeSummary actualPrizeSummary = lottoMachine.generatePrizeSummary();

        assertThat(actualPrizeSummary).usingRecursiveComparison()
                .isEqualTo(expectedPrizeSummary);
    }

    private static Stream<Arguments> totalPrizesDataProvider() {
        return Stream.of(
                Arguments.of(
                        WinningCombination.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.from(7)),
                        new LottoGroup(List.of(
                                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                                Lotto.from(List.of(1, 2, 3, 4, 5, 7)),
                                Lotto.from(List.of(1, 2, 3, 4, 5, 8)),
                                Lotto.from(List.of(1, 2, 3, 4, 8, 9)),
                                Lotto.from(List.of(1, 2, 3, 7, 8, 9)),
                                Lotto.from(List.of(8, 9, 10, 11, 12, 13))
                        )),
                        PrizeSummary.from(Map.of(
                                LottoPrize.FIRST_PRIZE, 1L,
                                LottoPrize.SECOND_PRIZE, 1L,
                                LottoPrize.THIRD_PRIZE, 1L,
                                LottoPrize.FOURTH_PRIZE, 1L,
                                LottoPrize.FIFTH_PRIZE, 1L,
                                LottoPrize.NOTHING, 1L
                        ))
                )
        );
    }

}
