package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.util.exception.input.BonusNumberNotUniqueException;
import lotto.util.exception.input.NumberGreaterException;
import lotto.util.exception.input.NumbersNegativeException;
import lotto.util.exception.input.NumbersNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    BonusNumber bonusNumber;
    WinningNumbers winningNumbers;
    String bonus;

    @BeforeEach
    void setUp() {
        bonus = "7";
        winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        this.bonusNumber = new BonusNumber(bonus, winningNumbers);
    }

    @Test
    void 보너스_넘버() {
        bonus = "7";
        assertThat(this.bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 예외_최대_숫자_테스트() {
        bonus = "46";
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumbers))
                .isInstanceOf(NumberGreaterException.class);
    }

    @Test
    void 예외_NULL_입력_테스트() {
        bonus = null;
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumbers))
                .isInstanceOf(NumbersNullException.class);
    }

    @Test
    void 예외_중복_문자_입력_테스트() {
        bonus = "1";
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumbers))
                .isInstanceOf(BonusNumberNotUniqueException.class);
    }

    @Test
    void 예외_음수_0_입력_테스트() {
        bonus = "-1";
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumbers))
                .isInstanceOf(NumbersNegativeException.class);
        bonus = "0";
        assertThatThrownBy(() -> new BonusNumber(bonus, winningNumbers))
                .isInstanceOf(NumbersNegativeException.class);
    }
}
