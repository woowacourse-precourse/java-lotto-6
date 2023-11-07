package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class LottoCashierTest {
    @ParameterizedTest
    @CsvSource({"10000, 10", "5000, 5", "2000, 2"})
    @DisplayName("금액에 따른 로또 발행 갯수를 정확하게 계산한다.")
    public void testGetLottoCount(int money, int expectedCount) {
        LottoCashier cashier = new LottoCashier();

        int count = cashier.getLottoCount(money);
        assertEquals(expectedCount, count);
    }
}
