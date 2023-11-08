package lotto.model;

import lotto.view.Messages;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BonusTest {

    @Test
    public void testValidBonusInitialization() {
        List<Integer> winningLottoNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        Bonus validBonus = new Bonus("35", new Lotto(winningLottoNumbers));
        assertNotNull(validBonus);
        assertEquals(35, validBonus.getNumber());
    }

    @Test
    public void testInvalidBonusInitialization() {
        List<Integer> winningLottoNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        Lotto lotto = new Lotto(winningLottoNumbers);

        // Invalid number (not a number)
        IllegalArgumentException invalidNumberException = assertThrows(IllegalArgumentException.class, () -> new Bonus("abc", lotto));
        assertEquals(Messages.LOTTO_STATE_ERROR_MESSAGE, invalidNumberException.getMessage());

        // Number out of range
        IllegalArgumentException outOfRangeException = assertThrows(IllegalArgumentException.class, () -> new Bonus("60", lotto));
        assertEquals(Messages.LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE, outOfRangeException.getMessage());

        // Duplicate number
        IllegalArgumentException duplicateException = assertThrows(IllegalArgumentException.class, () -> new Bonus("30", lotto));
        assertEquals(Messages.LOTTO_BONUS_DUPLICATE_MESSAGE, duplicateException.getMessage());
    }
}
