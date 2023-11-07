package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.InvalidLottoNumberRangeException;
import exception.NonNumericException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputBonusNumberViewTest {
    @DisplayName("입력이 1 ~ 45 밖일 시 예외 발생")
    @Test
    void createInputOutOfRange() {
        InputBonusNumberView view = new InputBonusNumberView();
        assertThatThrownBy(() -> view.validate("1050"))
                .isInstanceOf(InvalidLottoNumberRangeException.class);
    }

    @DisplayName("입력이 숫자가 아닐 시 예외 발생")
    @Test
    void createInputWithNonNumeric() {
        InputBonusNumberView view = new InputBonusNumberView();
        assertThatThrownBy(() -> view.validate("test"))
                .isInstanceOf(NonNumericException.class);
    }
}
