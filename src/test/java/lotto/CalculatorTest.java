package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @DisplayName("총 이익을 구한다.")
    @Test
    void profitTest(){
        List<MatchingCount> matchingCounts = new ArrayList<>();
        matchingCounts.add(MatchingCount.FOUR);
        matchingCounts.add(MatchingCount.FIVE_BONUS);
        matchingCounts.add(MatchingCount.THREE);
        int profit = calculator.getProfitMoney(matchingCounts);
        assertThat(profit).isEqualTo(50000 + 30000000 + 5000);
    }

    @DisplayName("수익률을 구한다.")
    @Test
    void profitPercentageTest(){
        double percentage1 = calculator.getProfitPercentage(12345000, 6);
        double percentage2 = calculator.getProfitPercentage(3000, 125);
        assertThat(percentage1).isEqualTo(205750);
        assertThat(percentage2).isEqualTo(2.4);
    }
}
