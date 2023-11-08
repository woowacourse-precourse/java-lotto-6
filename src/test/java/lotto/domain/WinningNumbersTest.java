package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("보너스 번호가 로또 번호 범위가 아닐 때 예외 처리")
    @Test
    void isInRangeTest() {
        assertThatThrownBy(() -> BonusNumber.makeBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호와 보너스번호가 겹치면 예외 처리")
    @Test
    void isNotDuplicateTest() {
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.makeBonusNumber(6);
        assertThatThrownBy(() -> new WinningNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("WinningNumbers 생성 테스트")
    @Test
    void makeWinningNumbersTest() {
        Lotto lotto = Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.makeBonusNumber(7);
        WinningNumbers winningNumbersTest = WinningNumbers.makeWinningNumbers(lotto, bonusNumber);
        assertThat(lotto).isEqualTo(winningNumbersTest.getWinningNumbers());
        assertThat(bonusNumber).isEqualTo(winningNumbersTest.getBonusNumber());
    }
}
