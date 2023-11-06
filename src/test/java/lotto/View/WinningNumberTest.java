package lotto.View;

import lotto.model.Price;
import lotto.model.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningNumberTest {
    /*
    @DisplayName("길이가 6이 아닌 숫자 입력")
    @Test
    public void checkNumberLengthTest() {
        Assertions.assertThatThrownBy(() -> new WinningNumber(List.of(1,2,3))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 범위가 1부터 45에서 벗어난 숫자 입력")
    @Test
    public void checkRangeTest() {
        Assertions.assertThatThrownBy(() -> WinningNumber.checkList.of(1,2,3,4,5,46))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber(List.of(0,2,3,4,5,6))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자 입력")
    @Test
    public void checkDuplicateTest() {
        Assertions.assertThatThrownBy(() -> WinningNumber.checkDuplicate(List.of(1,1,3,4,5,6))).isInstanceOf(IllegalArgumentException.class);
    }

     */

    @DisplayName("올바른 당첨 숫자 입력")
    @Test
    public void checkRightWinningNumberTest() {
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6));
        Assertions.assertThat(winningNumber.getWinningNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
