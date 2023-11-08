package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberValidatorTest {

    @Test
    void isValidFormat_정상입력_형식() {
        String winningNum = "1,2,3,4,5,6";
        String[] numbers = winningNum.split(",");
        assertThat(WinningNumberValidator.isValidFormat(numbers)).isEqualTo(true);
    }

    @Test
    void isValidFormat_비정상입력_형식() {
        String winningNum = "1,2,3,4";
        String[] numbers = winningNum.split(",");
        assertThatThrownBy(() -> WinningNumberValidator.isValidFormat(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 \"(숫자),(숫자),(숫자),(숫자),(숫자),(숫자)\" 꼴의 입력이어야 합니다.");
    }

    @Test
    void isNumbers_정상입력_숫자만() {
        String winningNum = "1,2,3,4,5,6";
        String[] numbers = winningNum.split(",");
        assertThat(WinningNumberValidator.isNumbers(numbers)).isEqualTo(true);
    }

    @Test
    void isNumbers_비정상입력_문자보유() {
        String winningNum = "1,2,3,a,5,6";
        String[] numbers = winningNum.split(",");
        assertThatThrownBy(() -> WinningNumberValidator.isNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호 중 숫자가 아닌 입력이 있습니다.");

    }

    @Test
    void isValidNumbers_정상입력_범위내() {
        String winningNum = "1,2,3,43,44,45";
        String[] numbers = winningNum.split(",");
        assertThat(WinningNumberValidator.isValidNumbers(numbers)).isEqualTo(true);
    }

    @Test
    void isValidNumbers_정상입력_범위외() {
        String winningNum = "0,1,2,44,45,46";
        String[] numbers = winningNum.split(",");
        assertThatThrownBy(() -> WinningNumberValidator.isValidNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void hasDuplicatedNumbers_정상입력_중복없음() {
        String winningNum = "1,2,3,4,5,6";
        String[] numbers = winningNum.split(",");
        assertThat(WinningNumberValidator.hasDuplicatedNumbers(numbers)).isEqualTo(false);
    }

    @Test
    void hasDuplicatedNumbers_정상입력_중복있음() {
        String winningNum = "1,1,3,4,5,6";
        String[] numbers = winningNum.split(",");
        assertThatThrownBy(() -> WinningNumberValidator.hasDuplicatedNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
    }
}