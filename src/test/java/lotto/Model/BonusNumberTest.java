package lotto.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    private BonusNumber bonusNumber;
    private List<Integer> winningNumbers;

    @BeforeEach
    public void setUp() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }
    @org.junit.Test
    public void testIllegalArgumentExceptionWithBonus6() {
        int bonus = 6;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonus, winningNumbers));
        assertTrue(exception.getMessage().contains("[ERROR]"));
    }

    @Test
    public void testIllegalArgumentExceptionWithBonus47() {
        int bonus = 47;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonus, winningNumbers));
        assertTrue(exception.getMessage().contains("[ERROR]"));
    }



}