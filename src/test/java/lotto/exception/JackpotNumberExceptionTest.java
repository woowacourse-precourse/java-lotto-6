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

}
