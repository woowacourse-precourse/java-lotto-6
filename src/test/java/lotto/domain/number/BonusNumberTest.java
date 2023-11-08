package lotto.domain.number;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberTest {
    @Test
    void testValidBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertDoesNotThrow(() -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @Test
    void testInvalidBonusNumberRange() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 0;

        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @Test
    void testDuplicateBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(winningNumbers, bonusNumber));
    }
}
