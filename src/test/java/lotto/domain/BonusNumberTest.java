package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.BonusNumber;
import domain.Lotto;
import domain.WinningNumbers;
import exception.DuplicateNumberException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복된 값을 지니고 있을 때 예외 처리한다.")
    void bonusNumberDuplicateWinningNumbers() {
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(1);
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThrows(DuplicateNumberException.class, () -> bonusNumber.exceptionIfDuplicate(winningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않은 경우")
    void bonusNumberNotDuplicateWinningNumbers() {
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(7);
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> bonusNumber.exceptionIfDuplicate(winningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 속하는 경우")
    void bonusNumberInLotto() {
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(1);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonusNumber.isMatch(lotto)).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 속하지 않는 경우")
    void bonusNumberNotInLotto() {
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonusNumber.isMatch(lotto)).isFalse();
    }
}