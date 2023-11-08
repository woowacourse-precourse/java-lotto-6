package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateResultTest {

    List<ComPareNumber> comPareNumbers = Arrays.asList(
            new ComPareNumber(Arrays.asList(1, 2, 3, 4, 5, 6),
                    Arrays.asList(1, 2, 3, 4, 40, 45), 10).calculateResults(),
            new ComPareNumber(Arrays.asList(7, 8, 9, 10, 11, 12),
                    Arrays.asList(7, 8, 9, 41, 42, 43), 10).calculateResults(),
            new ComPareNumber(Arrays.asList(13, 14, 15, 16, 17, 18),
                    Arrays.asList(1, 2, 3, 4, 5, 6), 10).calculateResults()
    );

    @DisplayName("총 당첨금액 계산")
    @Test
    void CalculateTotalSum() {

        long totalMoneySum = CalculateResult.calculateTotalMoneySum(comPareNumbers);
        assertThat(totalMoneySum).isEqualTo(55000);
    }

    @DisplayName("당첨 횟수 계산")
    @Test
    void calculateWinCounts() {
        List<Integer> expectedWinCounts = Arrays.asList(0, 0, 0, 1, 1);
        List<Integer> totalWinCounts = CalculateResult.calculateTotalWinCounts(comPareNumbers);
        assertThat(totalWinCounts).isEqualTo(expectedWinCounts);
    }


}
