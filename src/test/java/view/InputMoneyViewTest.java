package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.InvalidMoneyFormatException;
import exception.NonNumericException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputMoneyViewTest {
    @DisplayName("입력이 숫자가 아닐 경우 예외 발생")
    @Test
    void createNonNumericInput() {
        InputMoneyView view = new InputMoneyView();
        assertThatThrownBy(() -> view.validateNonNumeric("test"))
                .isInstanceOf(InvalidMoneyFormatException.class);
    }
}
