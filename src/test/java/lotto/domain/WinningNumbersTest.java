package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.dto.InputWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("입력받은 당첨 번호에 정수가 아닌 입력이 있을 경우 예외가 발생한다.")
    public void 당첨_번호_정수_아닌_경우() throws Exception {
        String winningNumbers = "a,2,3,4,5,6";
        assertThatThrownBy(() -> new InputWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 당첨 번호에 공백이 있을 경우 예외가 발생한다.")
    public void 당첨_번호_공백_제외() throws Exception {
        String winningNumbers = "1, 2,3,4, 5,6";
        assertThatThrownBy(() -> new InputWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("입력받은 당첨 번호가 6개보다 많으면 예외가 발생한다.")
    public void 당첨_번호_6개보다_많은_경우() throws Exception {
        //given
        String winningNumbers = "1,2,3,4,5,6,7";

        //then
        assertThrows(IllegalArgumentException.class, () -> new InputWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("입력받은 당첨 번호가 6개보다 적으면 예외가 발생한다.")
    public void 당첨_번호_6개보다_적은_경우() throws Exception {
        //given
        String winningNumbers = "1,2,3,4,5";

        //then
        assertThrows(IllegalArgumentException.class, () -> new InputWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("입력받은 당첨 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    public void 당첨_번호_범위() throws Exception {
        //given
        String winningNumberZero = "0,1,2,3,4,5";
        String winningNumberOver = "1,2,3,4,5,46";

        //then
        assertThrows(IllegalArgumentException.class, () -> new InputWinningNumbers(winningNumberZero));
        assertThrows(IllegalArgumentException.class, () -> new InputWinningNumbers(winningNumberOver));
    }

    @Test
    @DisplayName("입력받은 당첨 범위에 중복이 있을 경우 예외가 발생한다.")
    public void 당첨_번호_중복() throws Exception {
        //given
        String winnerNumbersDuplicate = "1,1,2,3,4,5";

        //then
        assertThrows(IllegalArgumentException.class, () -> new InputWinningNumbers(winnerNumbersDuplicate));
    }


}
