package lotto;

import lotto.controller.BonusNumberController;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusNumberTest {

    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createBonusRange() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 문자일 경우 예외가 발생한다.")
    @Test
    void createBonusWhenChar() {
        BonusNumberController bonusNumberController = new BonusNumberController();
        assertThatThrownBy(() -> bonusNumberController.parseBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 기존 로또 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void createBonusWhenDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        Bonus bonus = new Bonus(15);
        int actualResult = bonus.getBonusNumber();
        assertThatThrownBy(() -> lotto.validateBonusNumber(actualResult))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 정상이면 예외가 발생하지 않는다.")
    @Test
    void createBonusWhenRightRange() {
        Bonus bonus = new Bonus(1);
        int expectedResult = 1;
        assertEquals(expectedResult, bonus.getBonusNumber());
    }

    @DisplayName("보너스 번호가 중복되지 않으면 예외가 발생하지 않는다.")
    @Test
    void createBonusWhenNotDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        lotto.validateBonusNumber(16);
        Bonus bonus = new Bonus(16);
        int expectedResult = 16;
        assertEquals(expectedResult, bonus.getBonusNumber());
    }
}
