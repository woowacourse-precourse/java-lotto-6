package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameCalculatorTest {
    @Test
    public void testCountMatchedNumbers() {
        LottoGameCalculator calculator = new LottoGameCalculator();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTicket = Arrays.asList(1, 3, 5, 7, 9, 11);
        int matchedCount = calculator.countMatchedNumbers(winningNumbers, lottoTicket);
        assertEquals(3, matchedCount);
    }

    @Test
    public void testPurchaseAmountCalculator() {
        LottoGameCalculator calculator = new LottoGameCalculator();
        String purchasePrice = "5000";
        int result = calculator.purchaseAmountCalculator(purchasePrice);
        assertEquals(5, result);
    }

    @Test
    public void testIsMatchedBonusNumber() {
        LottoGameCalculator calculator = new LottoGameCalculator();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        boolean matched = calculator.isMatchedBonusNumber(winningNumbers, bonus);
        assertFalse(matched);
    }

}