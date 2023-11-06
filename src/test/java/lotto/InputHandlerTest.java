package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    private final InputHandler inputHandler = new InputHandler();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("가격 입력이 잘못된 경우")
    void inputTest() {
        String input = "2145g";
        assertThatThrownBy(() -> {
            inputHandler.readCost(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("1000원 단위로 나누어 떨어지지 않는 경우")
    void inputTest2() {
        String input = "12345";
        assertThatThrownBy(() -> {
            inputHandler.readCost(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("제대로 된 입력값의 경우")
    void inputTest3() {
        String input = "12000";
        assertThat(inputHandler.readCost(input)).isEqualTo(12000);
    }
}
