package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {

    @Test
    void divideMoney() {
        int money = LottoValidator.divideMoney("1000");
        Assertions.assertThat(money).isEqualTo(1000);
        Assertions.assertThatThrownBy(()-> LottoValidator.divideMoney("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkWinningNumber() {
        String[] correctNumber = {"1","2","3","4","5","6"};
        String[] wrongNumber = {"1","z","3","4","5","6"};
        String[] duplicateNumber = {"1","2","3","4","5","5"};
        String[] overNumber = {"1","2","3","4","5","6","7"};
        String[] overRange = {"1","2","3","4","5","6","46"};
        LottoValidator.checkWinningNumber(correctNumber);

        Assertions.assertThatThrownBy(() -> LottoValidator.checkWinningNumber(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> LottoValidator.checkWinningNumber(duplicateNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> LottoValidator.checkWinningNumber(overNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> LottoValidator.checkWinningNumber(overRange))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void checkBonusNumber() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        String bonus = "45";
        String duplicateBonus = "1";
        String wrongRangeBonus = "46";
        String string = "a";

        int number = LottoValidator.checkBonusNumber(bonus, list);
        Assertions.assertThat(number).isEqualTo(45);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->LottoValidator.checkBonusNumber(duplicateBonus, list));
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->LottoValidator.checkBonusNumber(wrongRangeBonus, list));
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->LottoValidator.checkBonusNumber(string, list));
    }
}