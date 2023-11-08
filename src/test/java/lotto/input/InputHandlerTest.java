package lotto.input;

import static lotto.constants.Error.EMPTY_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {
    @DisplayName("입력한 값이 없으면 예외가 발생한다.")
    @Test
    void inputNullValue() {
        assertThatThrownBy(() -> InputHandler.parseInputNumber(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(EMPTY_ERROR.getMessage());
    }

}