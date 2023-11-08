package lotto.input;

import static lotto.constants.Error.EMPTY_ERROR;
import static lotto.constants.Error.FORMAT_ERROR;
import static lotto.constants.Error.NOT_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {
    @DisplayName("입력한 값이 없으면 예외가 발생한다.")
    @Test
    void inputEmptyString() {
        assertThatThrownBy(() -> InputHandler.parseInputNumber(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(EMPTY_ERROR.getMessage());
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void inputNotNumberString() {
        assertThatThrownBy(() -> InputHandler.parseInputNumber("sjsalgkjalsdg"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(NOT_NUMBER_ERROR.getMessage());
    }

    @DisplayName("숫자를 입력하면 숫자가 반환된다")
    @Test
    void inputNumberString() {
        List<Integer> result = InputHandler.parseInputNumbers("1,2,3,4,5");
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @DisplayName("포맷에 맞지 않게 입력하면 예외가 발생한다.")
    @Test
    void inputNotMatchFormatString() {
        assertThatThrownBy(() -> InputHandler.parseInputNumbers(",,1,,2,,3,"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(FORMAT_ERROR.getMessage());
    }

    @DisplayName("포맷에 맞게 입력하면 숫자리스트가 반환된다")
    @Test
    void inputMatchFormatString() {
        List<Integer> result = InputHandler.parseInputNumbers("1,2,3,4,5");
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

}