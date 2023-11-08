package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameUtilsTest {

    @DisplayName("구입 금액에 따라 로또 생성")
    @ParameterizedTest
    @MethodSource("provideBudget")
    void testIssueLotto(long budget, int expected) {
        int actual = LottoGameUtils.issueLotto(budget).size();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideBudget() {
        return Stream.of(
                Arguments.of(10000, 10),
                Arguments.of(2000, 2),
                Arguments.of(6000, 6),
                Arguments.of(1000000, 1000),
                Arguments.of(5000, 5),
                Arguments.of(7000, 7)
        );
    }

    @DisplayName("잘못된 구입 금액에 대한 예외 처리")
    @ParameterizedTest
    @MethodSource("provideInvalidBudget")
    void testIssueLottoWithInvalidBudget(long budget) {
        assertThatThrownBy(() -> {
            LottoGameUtils.issueLotto(budget);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    static Stream<Arguments> provideInvalidBudget() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1111),
                Arguments.of(-1)
        );
    }

    @Test
    void testCreateLottoWinningWithNumbers() {
        // Tested in LottoWinning
    }

    @Test
    void testUpdateLottoWinningWithBonus() {
        // Tested in LottoWinning
    }

    @Test
    void testEvaluateLottoWinning() {
        // Tested in LottoWinning
    }

    @DisplayName("수익률 계산 기능")
    @ParameterizedTest
    @MethodSource("provideBudgetAndWinning")
    void testCalculateRateOfReturn(long budget, Map<LottoRank, Integer> winningCount, double expected) {
        double actual = LottoGameUtils.calculateRateOfReturn(budget, winningCount);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideBudgetAndWinning() {
        return Stream.of(
                Arguments.of(100000, getWinningCount(1,1,1,1,1), 20315.55),
                Arguments.of(200000, getWinningCount(1,2,1,1,1), 10158.025),
                Arguments.of(231000, getWinningCount(1,1,3,1,1), 8807.597402597403),
                Arguments.of(1000000, getWinningCount(3,1,1,1,1), 2031.565),
                Arguments.of(5000, getWinningCount(1,1,1,1,0), 6311.0)
        );
    }

    static Map<LottoRank, Integer> getWinningCount(
            int fifth, int fourth, int third, int second, int first) {
        Map<LottoRank, Integer> winningCount = new EnumMap(LottoRank.class);
        winningCount.put(LottoRank.FIFTH_PLACE, fifth);
        winningCount.put(LottoRank.FOURTH_PLACE, fourth);
        winningCount.put(LottoRank.THIRD_PLACE, third);
        winningCount.put(LottoRank.SECOND_PLACE, second);
        winningCount.put(LottoRank.FIRST_PLACE, first);
        return winningCount;
    }
}
