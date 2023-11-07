package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @Test
    void 당첨번호를_입력하기_전에_보너스_번호를_입력하면_오류_발생() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        int bonusNumber = 10;

        //when & then
        assertThrows(IllegalStateException.class, () -> winningNumber.setBonusNumber(bonusNumber));
    }

    @Test
    void 당첨번호와_중복된_보너스_번호일_경우_오류_발생() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 5;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> winningNumber.setBonusNumber(bonusNumber));
    }
}
