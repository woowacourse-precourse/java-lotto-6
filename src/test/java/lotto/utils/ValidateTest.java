package lotto.utils;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateTest {

    @Test
    void testPurchaseAmount() {
        // Test for valid input
        int validAmount = Validate.purchaseAmount("2000");
        assertEquals(2000, validAmount);

        // Test for input not divisible by 1000
        assertThrows(IllegalArgumentException.class, () -> Validate.purchaseAmount("1500"));
    }

    @Test
    void testLotteryNumber() {
        // Test for valid input
        int validNumber = Validate.lotteryNumber("12");
        assertEquals(12, validNumber);

        // Test for number out of range
        assertThrows(IllegalArgumentException.class, () -> Validate.lotteryNumber("50"));
    }

    @Test
    void testHasDuplicateNumbers() {
        // Test for a list with no duplicate numbers
        List<Integer> noDuplicateList = List.of(1, 2, 3, 4, 5);
        assertDoesNotThrow(() -> Validate.hasDuplicateNumbers(noDuplicateList));

        // Test for a list with duplicate numbers
        List<Integer> duplicateList = List.of(1, 2, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> Validate.hasDuplicateNumbers(duplicateList));
    }

    @Test
    void testBonusNumber() {
        // Test for a valid bonus number
        Lotto winningLottery = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int validBonusNumber = Validate.bonusNumber(winningLottery, "7");
        assertEquals(7, validBonusNumber);

        // Test for a bonus number that already exists in the winningLottery
        assertThrows(IllegalArgumentException.class, () -> Validate.bonusNumber(winningLottery, "6"));

        // Test for an invalid bonus number
        assertThrows(IllegalArgumentException.class, () -> Validate.bonusNumber(winningLottery, "50"));
    }
}
