package lotto.model;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
    @DisplayName("보너스 번호가 1~45의 값을 가지지 않을 때 예외 발생")
    @Test
    void createBonusNumberInvalidRange() {
        assertThatThrownBy(() -> new BonusNumber(winningNumber, "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등 로또 번호와 중복된 보너스 번호 입력시 예외 발생")
    @Test
    void createBonusNumberByDuplicateNumber() {
        assertThatThrownBy(() -> new BonusNumber(winningNumber, "3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 입력시 예외 발생")
    @Test
    void createBonusNumberByEmpty() {
        assertThatThrownBy(() -> new BonusNumber(winningNumber, ""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}