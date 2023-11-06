package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {
    final String WINNING_NUMBER = "1,2,3,4,5,6";
    @Test
    @DisplayName("입력된 당첨 번호 정상 입력 확인")
    void inputWinningNumber(){
        WinningNumber winningNumber = new WinningNumber(WINNING_NUMBER);
        Lotto expectedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber).isEqualTo(expectedLotto);
    }
}