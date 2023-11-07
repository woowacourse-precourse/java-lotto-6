package lotto.domain;

import lotto.constant.LottoRank;
import lotto.util.FakeNumberGenerator;
import lotto.util.NumberGenerator.INumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoStatistics 테스트")
class LottoStatisticsTest {

    @DisplayName("toString 테스트")
    @Nested
    class toString {

        @DisplayName("3개 미만 당첨 검사")
        @Test
        void checkNOTHING() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsNOTHING();
            assertThat(lottoStatistics.toString())
                    .doesNotContain("1개");
        }

        @DisplayName("3개 당첨 검사")
        @Test
        void checkTHREE() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsTHREE();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.THREE.toString(1));
        }

        @DisplayName("4개 당첨 검사")
        @Test
        void checkFOUR() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsFOUR();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.FOUR.toString(1));
        }

        @DisplayName("5개 당첨 검사")
        @Test
        void checkFIVE() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsFIVE();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.FIVE.toString(1));
        }

        @DisplayName("5개, 보너스 당첨 검사")
        @Test
        void checkFIVE_BONUS() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsFIVE_BONUS();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.FIVE_BONUS.toString(1));
        }

        @DisplayName("6개 당첨 검사")
        @Test
        void checkSIX() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsSIX();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.SIX.toString(1));
        }

    }

    @DisplayName("calculateIncome 테스트")
    @Nested
    class calculateIncome {

        @DisplayName("3개 미만 당첨 가격 검사")
        @Test
        void checkNOTHING() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsNOTHING();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.NOTHING.getPrize());
        }

        @DisplayName("3개 당첨 가격 검사")
        @Test
        void checkTHREE() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsTHREE();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.THREE.getPrize());
        }

        @DisplayName("4개 당첨 가격 검사")
        @Test
        void checkFOUR() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsFOUR();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.FOUR.getPrize());
        }

        @DisplayName("5개 당첨 가격 검사")
        @Test
        void checkFIVE() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsFIVE();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.FIVE.getPrize());
        }

        @DisplayName("5개, 보너스 당첨 가격 검사")
        @Test
        void checkFIVE_BONUS() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsFIVE_BONUS();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.FIVE_BONUS.getPrize());

        }

        @DisplayName("6개 당첨 가격 검사")
        @Test
        void checkSIX() {
            LottoStatistics lottoStatistics = LottoStatisticsBuilder.getLottoStatisticsSIX();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.SIX.getPrize());
        }

    }

}

class LottoStatisticsBuilder {

    private LottoStatisticsBuilder() {
    }

    private static Result buildResult(List<Integer> winningNumberIntegers, int bonusNumberInteger) {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(winningNumberIntegers);
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInteger);
        return new Result(winningNumbers, bonusNumber);
    }

    private static LottoPack buildLottoPack(List<Integer> numbers) {
        INumberGenerator numberGenerator = new FakeNumberGenerator(numbers);
        return new LottoPack(1, numberGenerator);
    }

    public static LottoStatistics getLottoStatisticsNOTHING() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(40, 41, 42, 43, 44, 45));
        return new LottoStatistics(lottoPack, result);
    }

    public static LottoStatistics getLottoStatisticsTHREE() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 43, 44, 45));
        return new LottoStatistics(lottoPack, result);
    }

    public static LottoStatistics getLottoStatisticsFOUR() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 44, 45));
        return new LottoStatistics(lottoPack, result);
    }

    public static LottoStatistics getLottoStatisticsFIVE() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 5, 45));
        return new LottoStatistics(lottoPack, result);
    }

    public static LottoStatistics getLottoStatisticsFIVE_BONUS() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 5, 7));
        return new LottoStatistics(lottoPack, result);
    }

    public static LottoStatistics getLottoStatisticsSIX() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 5, 6));
        return new LottoStatistics(lottoPack, result);
    }

}