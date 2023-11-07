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

    private final LottoStatisticsBuilder lottoStatisticsBuilder;

    LottoStatisticsTest() {
        lottoStatisticsBuilder = new LottoStatisticsBuilder();
    }

    @DisplayName("toString 테스트")
    @Nested
    class toString {

        @DisplayName("3개 미만 당첨 검사")
        @Test
        void checkNOTHING() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsNOTHING();
            assertThat(lottoStatistics.toString())
                    .doesNotContain("1개");
        }

        @DisplayName("3개 당첨 검사")
        @Test
        void checkTHREE() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsTHREE();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.THREE.toString(1));
        }

        @DisplayName("4개 당첨 검사")
        @Test
        void checkFOUR() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsFOUR();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.FOUR.toString(1));
        }

        @DisplayName("5개 당첨 검사")
        @Test
        void checkFIVE() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsFIVE();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.FIVE.toString(1));
        }

        @DisplayName("5개, 보너스 당첨 검사")
        @Test
        void checkFIVE_BONUS() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsFIVE_BONUS();
            assertThat(lottoStatistics.toString())
                    .contains(LottoRank.FIVE_BONUS.toString(1));
        }

        @DisplayName("6개 당첨 검사")
        @Test
        void checkSIX() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsSIX();
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
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsNOTHING();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.NOTHING.getPrize());
        }

        @DisplayName("3개 당첨 가격 검사")
        @Test
        void checkTHREE() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsTHREE();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.THREE.getPrize());
        }

        @DisplayName("4개 당첨 가격 검사")
        @Test
        void checkFOUR() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsFOUR();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.FOUR.getPrize());
        }

        @DisplayName("5개 당첨 가격 검사")
        @Test
        void checkFIVE() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsFIVE();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.FIVE.getPrize());
        }

        @DisplayName("5개, 보너스 당첨 가격 검사")
        @Test
        void checkFIVE_BONUS() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsFIVE_BONUS();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.FIVE_BONUS.getPrize());

        }

        @DisplayName("6개 당첨 가격 검사")
        @Test
        void checkSIX() {
            LottoStatistics lottoStatistics = lottoStatisticsBuilder.getLottoStatisticsSIX();
            assertEquals(lottoStatistics.calculateIncome(), LottoRank.SIX.getPrize());
        }

    }

}

class LottoStatisticsBuilder {

    private Result buildResult(List<Integer> winningNumberIntegers, int bonusNumberInteger) {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(winningNumberIntegers);
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInteger);
        return new Result(winningNumbers, bonusNumber);
    }

    public LottoStatistics getLottoStatisticsNOTHING() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(40, 41, 42, 43, 44, 45));
        return new LottoStatistics(lottoPack, result);
    }

    private LottoPack buildLottoPack(List<Integer> numbers) {
        INumberGenerator numberGenerator = new FakeNumberGenerator(numbers);
        return new LottoPack(1, numberGenerator);
    }

    public LottoStatistics getLottoStatisticsTHREE() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 43, 44, 45));
        return new LottoStatistics(lottoPack, result);
    }

    public LottoStatistics getLottoStatisticsFOUR() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 44, 45));
        return new LottoStatistics(lottoPack, result);
    }

    public LottoStatistics getLottoStatisticsFIVE() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 5, 45));
        return new LottoStatistics(lottoPack, result);
    }

    public LottoStatistics getLottoStatisticsFIVE_BONUS() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 5, 7));
        return new LottoStatistics(lottoPack, result);
    }

    public LottoStatistics getLottoStatisticsSIX() {
        Result result = buildResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPack lottoPack = buildLottoPack(List.of(1, 2, 3, 4, 5, 6));
        return new LottoStatistics(lottoPack, result);
    }

}