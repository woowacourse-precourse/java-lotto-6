package lotto.domain;

import lotto.constant.LottoRank;
import lotto.util.FakeNumberGenerator;
import lotto.util.NumberGenerator.INumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoStatistics 테스트")
class LottoStatisticsTest {

    @DisplayName("toString 테스트")
    @Nested
    class toString {

        @DisplayName("당첨을 잘 검사하는지 확인")
        @ParameterizedTest
        @MethodSource("provideLottoStatisticsAndResult")
        void checkLottoRank(LottoStatistics lottoStatistics, LottoRank lottoRank) {

            if (lottoRank.equals(LottoRank.NOTHING)) {
                assertThat(lottoStatistics.toString())
                        .doesNotContain("1개 일치");
                return;
            }

            assertThat(lottoStatistics.toString())
                    .contains(lottoRank.toString(1));

        }

        private static Stream<Arguments> provideLottoStatisticsAndResult() {
            return LottoStatisticsTest.provideLottoStatisticsAndResult();
        }

    }

    @DisplayName("calculateIncome 테스트")
    @Nested
    class calculateIncome {

        @DisplayName("가격을 잘 검사하는지 확인")
        @ParameterizedTest
        @MethodSource("provideLottoStatisticsAndResult")
        void checkPrize(LottoStatistics lottoStatistics, LottoRank lottoRank) {
            assertEquals(lottoStatistics.calculateIncome(), lottoRank.getPrize());
        }

        private static Stream<Arguments> provideLottoStatisticsAndResult() {
            return LottoStatisticsTest.provideLottoStatisticsAndResult();
        }

    }

    private static Stream<Arguments> provideLottoStatisticsAndResult() {
        Result result = getResult(List.of(1, 2, 3, 4, 5, 6), 7);
        return Stream.of(
                Arguments.of(getLottoStatistics(List.of(40, 41, 42, 43, 44, 45), result), LottoRank.NOTHING),
                Arguments.of(getLottoStatistics(List.of(1, 2, 3, 43, 44, 45), result), LottoRank.THREE),
                Arguments.of(getLottoStatistics(List.of(1, 2, 3, 4, 44, 45), result), LottoRank.FOUR),
                Arguments.of(getLottoStatistics(List.of(1, 2, 3, 4, 5, 45), result), LottoRank.FIVE),
                Arguments.of(getLottoStatistics(List.of(1, 2, 3, 4, 5, 7), result), LottoRank.FIVE_BONUS),
                Arguments.of(getLottoStatistics(List.of(1, 2, 3, 4, 5, 6), result), LottoRank.SIX)
        );
    }

    private static LottoStatistics getLottoStatistics(List<Integer> numbers, Result result) {
        return new LottoStatistics(getLottoPack(numbers), result);
    }

    private static Result getResult(List<Integer> winningNumberIntegers, int bonusNumberInteger) {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(winningNumberIntegers);
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInteger);
        return new Result(winningNumbers, bonusNumber);
    }

    private static LottoPack getLottoPack(List<Integer> numbers) {
        INumberGenerator numberGenerator = new FakeNumberGenerator(numbers);
        return new LottoPack(1, numberGenerator);
    }

}
