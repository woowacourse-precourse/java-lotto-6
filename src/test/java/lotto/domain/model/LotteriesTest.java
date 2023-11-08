package lotto.domain.model;

import lotto.constant.RankConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteriesTest {

    private static List<List<Integer>> provideListsForProduceStatics() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 8, 7),
                Arrays.asList(1, 2, 3, 9, 8, 7),
                Arrays.asList(1, 2, 3, 9, 8, 7)
        );
    }

    private static Stream<Arguments> provideObjects() {
        // 여기에서 객체를 생성하고 Arguments로 래핑하여 반환
        return Stream.of(
                Arguments.of(new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(7))
        );
    }

    @DisplayName("당첨 통계가 반환되는지 확인한다.")
    @Test
    void produceStatistics() {
        // Given
        Lotteries lotteries = new Lotteries();
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        List<List<Integer>> listForCreateLotteries = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 8),
                Arrays.asList(1, 2, 3, 4, 8, 7),
                Arrays.asList(1, 2, 3, 9, 8, 7)
        );

        for (List<Integer> listForCreateLotto : listForCreateLotteries) {
            lotteries.add(new Lotto(listForCreateLotto));
        }

        // When
        Map<String, Integer> mapForTest = lotteries.produceStatistics(winningNumber, bonusNumber);

        // Then
        assertEquals(1, mapForTest.get(RankConstant.FIRST));
        assertEquals(1, mapForTest.get(RankConstant.SECOND));
        assertEquals(1, mapForTest.get(RankConstant.THIRD));
        assertEquals(1, mapForTest.get(RankConstant.FOURTH));
        assertEquals(1, mapForTest.get(RankConstant.FIFTH));
    }

    @DisplayName("수익률이 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1000, 203_155_500.0",
            "10000, 20_315_550.0",
            "2000, 101_577_750.0",
            "3000, 67_718_500.0",
            "4000, 50_788_875.0",
            "5000, 40_631_100.0"
    })
    void calculateTotalReturnAsPercent(int inputMoney, double expectResult) {
        // Given
        Lotteries lotteries = new Lotteries();
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 1);
        statics.put(RankConstant.SECOND, 1);
        statics.put(RankConstant.THIRD, 1);
        statics.put(RankConstant.FOURTH, 1);
        statics.put(RankConstant.FIFTH, 1);

        // When
        double totalReturnAsPercent = lotteries.calculateTotalReturnAsPercent(inputMoney, statics);

        assertEquals(expectResult, totalReturnAsPercent);
    }

    @DisplayName("5등 당첨일 때, 수익률이 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1000, 500.0",
            "10000, 50.0",
            "2000, 250.0",
            "3000, 166.7",
            "4000, 125.0",
            "8000, 62.5",
            "5000, 100.0"
    })
    void calculateTotalReturnAsPercentFifth(int inputMoney, double expectResult) {
        // Given
        Lotteries lotteries = new Lotteries();
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 0);
        statics.put(RankConstant.SECOND, 0);
        statics.put(RankConstant.THIRD, 0);
        statics.put(RankConstant.FOURTH, 0);
        statics.put(RankConstant.FIFTH, 1);

        // When
        double totalReturnAsPercent = lotteries.calculateTotalReturnAsPercent(inputMoney, statics);

        assertEquals(expectResult, totalReturnAsPercent);
    }

    @DisplayName("4등 당첨일 때, 수익률이 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1000, 5000.0",
            "10000, 500.0",
            "2000, 2500.0",
            "3000, 1666.7",
            "4000, 1250.0",
            "5000, 1000.0"
    })
    void calculateTotalReturnAsPercentFourth(int inputMoney, double expectResult) {
        // Given
        Lotteries lotteries = new Lotteries();
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 0);
        statics.put(RankConstant.SECOND, 0);
        statics.put(RankConstant.THIRD, 0);
        statics.put(RankConstant.FOURTH, 1);
        statics.put(RankConstant.FIFTH, 0);

        // When
        double totalReturnAsPercent = lotteries.calculateTotalReturnAsPercent(inputMoney, statics);

        assertEquals(expectResult, totalReturnAsPercent);
    }

    @DisplayName("3등 당첨일 때, 수익률이 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1000, 150000.0",
            "10000, 15000.0",
            "2000, 75000.0",
            "3000, 50000.0",
            "4000, 37500.0",
            "5000, 30000.0"
    })
    void calculateTotalReturnAsPercentThird(int inputMoney, double expectResult) {
        // Given
        Lotteries lotteries = new Lotteries();
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 0);
        statics.put(RankConstant.SECOND, 0);
        statics.put(RankConstant.THIRD, 1);
        statics.put(RankConstant.FOURTH, 0);
        statics.put(RankConstant.FIFTH, 0);

        // When
        double totalReturnAsPercent = lotteries.calculateTotalReturnAsPercent(inputMoney, statics);

        assertEquals(expectResult, totalReturnAsPercent);
    }

    @DisplayName("2등 당첨일 때, 수익률이 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1000, 3_000_000.0",
            "10000, 300_000.0",
            "2000, 1_500_000.0",
            "3000, 1_000_000.0",
            "4000, 750_000.0",
            "5000, 600_000.0"
    })
    void calculateTotalReturnAsPercentSecond(int inputMoney, double expectResult) {
        // Given
        Lotteries lotteries = new Lotteries();
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 0);
        statics.put(RankConstant.SECOND, 1);
        statics.put(RankConstant.THIRD, 0);
        statics.put(RankConstant.FOURTH, 0);
        statics.put(RankConstant.FIFTH, 0);

        // When
        double totalReturnAsPercent = lotteries.calculateTotalReturnAsPercent(inputMoney, statics);

        assertEquals(expectResult, totalReturnAsPercent);
    }

    @DisplayName("1등 당첨일 때, 수익률이 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1000, 200_000_000.0",
            "10000, 20_000_000.0",
            "2000, 100_000_000.0",
            "3000, 66_666_666.7",
            "4000, 50_000_000.0",
            "5000, 40_000_000.0"
    })
    void calculateTotalReturnAsPercentFirst(int inputMoney, double expectResult) {
        // Given
        Lotteries lotteries = new Lotteries();
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 1);
        statics.put(RankConstant.SECOND, 0);
        statics.put(RankConstant.THIRD, 0);
        statics.put(RankConstant.FOURTH, 0);
        statics.put(RankConstant.FIFTH, 0);

        // When
        double totalReturnAsPercent = lotteries.calculateTotalReturnAsPercent(inputMoney, statics);

        assertEquals(expectResult, totalReturnAsPercent);
    }
}