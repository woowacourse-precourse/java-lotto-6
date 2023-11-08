package lotto.domain.number;

import lotto.domain.Lotto;
import lotto.domain.number.BonusNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberTest {

    @Test
    void testValidBonusNumber() {
        // 유효한 보너스 번호
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @Test
    void testInvalidBonusNumberRange() {
        // 유효하지 않은 범위의 보너스 번호
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 0;

        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @Test
    void testDuplicateBonusNumber() {
        // 이미 로또 번호 목록에 있는 보너스 번호
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(winningNumbers, bonusNumber));
    }
}
