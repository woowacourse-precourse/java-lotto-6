package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외 발생")
    @Test
    void checkWinningNumberLength() {
        //given
        WinningNumber winningNumber = new WinningNumber();

        //when
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //then
        Assertions.assertThatThrownBy(() -> winningNumber.checkWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
    }

    @DisplayName("당첨 번호가 1~45사이의 값이 아니면 예외 발생")
    @Test
    void checkWinningNumberRange() {
        //given

        //when

        //then
    }

    @Test
    void checkBonusNumber() {
    }

    @Test
    void toWinningNumberList() {
    }

    @Test
    void compareToLotto() {
    }
}