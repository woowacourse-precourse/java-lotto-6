package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @DisplayName("당첨 번호는 6개의 숫자")
    @Test
    public void winningNumbersSize() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(winning, bonusNumber);

        assertAll(
                () -> assertThat(winningNumbers.getWinningNumbers()).isEqualTo(winning),
                () -> assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber.getBonusNumber())
        );
    }

    @DisplayName("로또 번호 범위 초과 시 예외 발생")
    @Test
    public void invalidWinningNumberSize() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6, 7);
        BonusNumber bonusNumber = new BonusNumber(8);

        assertThatThrownBy(() -> new WinningNumbers(winning, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 - 45의 당첨 로또 숫자 범위 초과 시 예외 발생")
    @Test
    public void invalidWinningNumberRange() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 46);
        BonusNumber bonusNumber = new BonusNumber(8);

        assertThatThrownBy(() -> new WinningNumbers(winning, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 - 45의 보너스 숫자 범위 초과 시 예외 발생")
    @Test
    public void invalidBonusNumberRange() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 45);

        assertThatThrownBy(() -> new WinningNumbers(winning, new BonusNumber(46))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 숫자 중복 예외 발생")
    @Test
    public void winningNumberDuplicate() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 5);
        BonusNumber bonusNumber = new BonusNumber(45);

        assertThatThrownBy(() -> new WinningNumbers(winning, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자 중복 예외 발생")
    @Test
    public void bonusNumberDuplicate() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> new WinningNumbers(winning, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
