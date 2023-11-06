package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EarningRateTest {
    @ParameterizedTest
    @CsvSource(value = {"8000/5000/62.5%",
            "1000/1000/100.0%",
            "2000/2000000000/1,000,000.0%",
            "10000/9995/100.0%"},
            delimiter = '/')
    void 수익률_계산_테스트(int amount, int earning, String expected) {
        EarningRate earningRate = new EarningRate(amount, earning);
        assertEquals(earningRate.toString(), expected);
    }
}
