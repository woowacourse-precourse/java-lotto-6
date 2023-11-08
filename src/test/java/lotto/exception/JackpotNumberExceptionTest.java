package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JackpotNumberExceptionTest {

    @DisplayName("당첨번호 입력 시 쉼표(,)가 없으면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberByNoComma() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 숫자외의 다른 문자를 입력하면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberByNotNumber() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("1,2,3,4,5,e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 빈칸을 입력하면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberBySpace() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("1,2, ,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 숫자 6개 미만을 입력하면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberBySmallSize() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 숫자 6개를 초과하여 입력하면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberByLargeSize() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 쉼표(,)로 끝나면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberByEndOfComma() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 1~45 범위 밖의 숫자를 입력하면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberByOutOfRange() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("1,2,3,4,5,99"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 아무것도 입력하지 않으면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberByNoInput() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    public void inputJackpotNumberByDuplicateNumber() {
        assertThatThrownBy(() -> InputValidator.checkJackpotNumberInput("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
