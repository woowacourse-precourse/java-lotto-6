package lotto.model;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinnigNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ONLY_SIZE_IS_SIX);
    }

    @DisplayName("당첨 번호가 비어있으면 예외가 발생한다.")
    @Test
    void createWinnigNumberByEmpty() {
        assertThatThrownBy(() -> new WinningNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EMPTY_OR_BLANK);
    }

    @DisplayName("당첨 번호가 공백이면 예외가 발생한다.")
    @Test
    void createWinnigNumberByBlank() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4, ,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EMPTY_OR_BLANK);
    }

    @DisplayName("당첨 번호가 중복이 있으면 예외가 발생한다.")
    @Test
    void createWinnigNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_DUPLICATE);
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinnigNumberByString() {
        assertThatThrownBy(() -> new WinningNumber("1,r,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.IS_NOT_DIGIT);
    }

    @DisplayName("당첨 번호에 음수가 포함되어 있을 경우 예외가 발생한다.")
    @Test
    void createWinnigNumberByMinus() {
        assertThatThrownBy(() -> new WinningNumber("1,-2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    @DisplayName("당첨 번호에 0이 포함되어 있을 경우 예외가 발생한다.")
    @Test
    void createWinnigNumberByZero() {
        assertThatThrownBy(() -> new WinningNumber("1,0,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    @DisplayName("보너스 번호가 0일 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByZero() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        //when & then
        assertThatThrownBy(() -> winningNumber.setBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    @DisplayName("보너스 번호가 음수일 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByMinus() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        //when & then
        assertThatThrownBy(() -> winningNumber.setBonusNumber("-10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByString() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        //when & then
        assertThatThrownBy(() -> winningNumber.setBonusNumber("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.IS_NOT_DIGIT);
    }

    @DisplayName("보너스 번호가 공백일 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByBlank() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        //when & then
        assertThatThrownBy(() -> winningNumber.setBonusNumber(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EMPTY_OR_BLANK);
    }

    @DisplayName("보너스 번호가 빈 칸일 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByEmpty() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        //when & then
        assertThatThrownBy(() -> winningNumber.setBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EMPTY_OR_BLANK);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복일 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByDuplicatedNumber() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        //when & then
        assertThatThrownBy(() -> winningNumber.setBonusNumber("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_DUPLICATE);
    }

}
