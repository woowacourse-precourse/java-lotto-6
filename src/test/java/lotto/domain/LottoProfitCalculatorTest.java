package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoProfitCalculatorTest {
    @Test
    public void totalProfitTest(){
        Map<Integer, Integer> test = new HashMap<>();

        IntStream.rangeClosed(3, 7).forEach(value -> test.put(value, 1));

        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(test, 3);

        assertEquals(lottoProfitCalculator.totalProfit(test), 2031555000);
    }

    @Test
    public void totalProfitPercentileTest(){
        Map<Integer, Integer> test = new HashMap<>();

        IntStream.rangeClosed(3, 7).forEach(value -> test.put(value, 1));

        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(test, 3);

        assertEquals(lottoProfitCalculator.getTotalProfitPercentile(), "677185.0");
    }
}