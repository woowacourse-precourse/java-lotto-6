package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import constants.Grade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointResultTest {
    @Test
    @DisplayName("각 등수별 당첨 로또 번호의 수를 집계한다.")
    void pointResultTest() {
        //Given
        List<Double> points = new ArrayList<>(List.of(1.0, 3.0, 4.0, 5.0, 5.5, 6.0, 6.0));
        PointResult pointResult = new PointResult(points);

        //When & Then
        assertThat(pointResult.getCountByGrade(Grade.FIRST)).isEqualTo(2);
        assertThat(pointResult.getCountByGrade(Grade.SECOND)).isEqualTo(1);
        assertThat(pointResult.getCountByGrade(Grade.THIRD)).isEqualTo(1);
        assertThat(pointResult.getCountByGrade(Grade.FOURTH)).isEqualTo(1);
        assertThat(pointResult.getCountByGrade(Grade.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익을 계산한다.")
    void calculateTotalPrizeMoneyTest() {
        //Given
        List<Double> points = new ArrayList<>(List.of(1.0, 3.5, 4.0, 5.0, 5.5, 6.0, 6.0));
        PointResult pointResult = new PointResult(points);

        //When
        int result = pointResult.calculateTotalPrizeMoney();
        int expectedResult =
                Grade.FIRST.getPrizeMoney() * 2 + Grade.SECOND.getPrizeMoney() + Grade.THIRD.getPrizeMoney()
                        + Grade.FOURTH.getPrizeMoney();

        //When & Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"3.0, 8000", "'3.0, 4.0', 15000"}, delimiter = ',')
    @DisplayName("수익률을 계산한다.")
    void calculateEarningRate(String inputPoints, int inputMoney) {
        //Given
        List<Double> points = Arrays.stream(inputPoints.split(","))
                .map(Double::valueOf)
                .collect(Collectors.toList());
        PointResult pointResult = new PointResult(points);
        Money money = new Money(inputMoney);

        //When
        double result = pointResult.calculateEarningRate(money);
        double expectedResult = (double) pointResult.calculateTotalPrizeMoney() / money.getMoney() * 100;

        //Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
