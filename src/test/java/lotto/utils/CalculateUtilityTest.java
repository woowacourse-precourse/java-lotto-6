package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculateUtilityTest {

    @DisplayName("랭킹에 따른 당첨 개수를 주면, 총 상금 금액을 계산해준다.")
    @ParameterizedTest
    @CsvSource(value = {"'1,0,0,0,0', '2000000000'", "'0,1,0,0,0', '30000000'", "'0,0,1,2,1', '1605000'",
            "'0,1,0,1,3', '30065000'"})
    void calculatePrizeSum(String numbersCsv, String expectedCsv) {

        Map<Ranking, Integer> map = new HashMap<>();

        int[] winningResult = Arrays.stream(numbersCsv.split(",")).map(String::trim)
                .mapToInt(Integer::parseInt).toArray();
        insertMapValues(map, winningResult);

        Long actual = CalculateUtility.calculatePrizeSum(map);
        Long expected = Long.parseLong(expectedCsv);

        assertThat(actual).isEqualTo(expected);
    }

    private static void insertMapValues(Map<Ranking, Integer> map, int[] arr) {
        map.put(Ranking.FIRST_PLACE, arr[0]);
        map.put(Ranking.SECOND_PLACE, arr[1]);
        map.put(Ranking.THIRD_PLACE, arr[2]);
        map.put(Ranking.FOURTH_PLACE, arr[3]);
        map.put(Ranking.FIFTH_PLACE, arr[4]);
        map.put(Ranking.NO_PRIZE, 0);
    }

    @DisplayName("수익금과 비용을 주면, 수익률을 계산해준다.")
    @ParameterizedTest
    @CsvSource(value = {"'5000','71.43'", "'55000','785.71'", "'1505000','21500'"})
    void calculateEarningsRate(String earningsCsv, String expectedCsv) {
        long earnings = Long.parseLong(earningsCsv);
        int cost = 7000;

        double actual = CalculateUtility.calculateEarningsRate(earnings, cost);
        double expected = Double.parseDouble(expectedCsv);
        double delta = 0.01;

        assertThat(actual).isCloseTo(expected, within(delta));
    }
}
