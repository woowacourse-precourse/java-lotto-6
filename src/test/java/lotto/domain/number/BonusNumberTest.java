package lotto.domain.number;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberTest {
    @DisplayName("유효한 보너스 번호 입력 시 예외가 발생하지 않는다.")
    @Test
    void testValidBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertDoesNotThrow(() -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @DisplayName("보너스 번호 값의 범위 미만일 시 예외가 발생한다.")
    @Test
    void testBonusNumberWithInvalidLowRange() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 0;

        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @DisplayName("보너스 번호 값의 범위 초과할 시 예외가 발생한다.")
    @Test
    void testBonusNumberWithInvalidHighRange() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;

        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @DisplayName("보너스 번호가 null일 시 예외가 발생한다.")
    @Test
    void testBonusNumberWithNullValue() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThrows(NullPointerException.class, () -> new BonusNumber(winningNumbers, (Integer) null));
    }

    @DisplayName("기존 당첨 번호와 중복된 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void testDuplicateBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(winningNumbers, bonusNumber));
    }
}
