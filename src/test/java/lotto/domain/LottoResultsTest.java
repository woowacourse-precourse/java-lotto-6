package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private LottoResults lottoResults;

    @BeforeEach
    void init() {
        lottoResults = new LottoResults();
        lottoResults.addResult(3, false);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateProfitRate() {
        double profitRate = lottoResults.calculateProfitRate(8000);
        assertEquals(62.5, profitRate);
    }
}