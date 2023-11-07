package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.EmptyException;
import exception.NonNumericException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputWinningLottoViewTest {
    @DisplayName("입력에 공백이 있을 시 예외 발생")
    @Test
    void createInputWithEmpty() {
        InputWinningLottoView view = new InputWinningLottoView();

        assertThatThrownBy(() -> view.validate(""))
                .isInstanceOf(EmptyException.class);
    }

    @DisplayName("입력이 숫자가 아닐 경우 예외 발생")
    @Test
    void createInputWithNonNumeric() {
        InputWinningLottoView view = new InputWinningLottoView();

        assertThatThrownBy(() -> view.validate("asdfa"))
                .isInstanceOf(NonNumericException.class);
    }
}
