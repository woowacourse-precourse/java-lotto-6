package lotto.model;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    final String WINNING_NUMBER = "1,2,3,4,5,6";
    @Test
    @DisplayName("입력된 당첨 번호 정상 입력 확인")
    void inputWinningNumber(){
        WinningNumber winningNumber = new WinningNumber(WINNING_NUMBER);
        Lotto expectedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber).isEqualTo(expectedLotto);
    }

    @Test
    @DisplayName("로또 번호에 1~45 범위의 숫자가 아닌 숫자가 있으면 예외가 발생한다.")
    void createLottoByNotValidatedRangeNumber(){
        assertThatThrownBy(() -> new WinningNumber("0,2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 입력시 문자가 입력 되면 예외가 발생한다.")
    void createLottoByLetter(){
        assertThatThrownBy(() -> new WinningNumber("letter"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}