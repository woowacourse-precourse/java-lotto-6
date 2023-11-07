package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    private HashMap result = new HashMap<>();
    private HashMap testResult = new HashMap<>();

    @Test
    void statistics() {
        for (int i = 0; i < 5; i++) {
            result.put(i,0);
        }
        for (int i = 0; i < 5; i++) {
            testResult.put(i,1);
        }
        new LottoResult(result);
        for (int i = 3; i < 7; i++) {
            LottoResult.statistics(i,0);
        }
        LottoResult.statistics(5,1);
        assertThat(result).isEqualTo(testResult);
    }

    @Test
    void calculateProfit() {
        for (int i = 0; i < 5; i++) {
            result.put(i,0);
        }
        result.put(1,1);
        new LottoResult(result);
        double profit = LottoResult.calculateProfit(2);
        assertThat(profit).isEqualTo(1500000);
    }
}