package lotto.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberInputManagerTest {
    private WinningNumberInputManager winningNumberInputManager;
    private ConsoleAdapter consoleAdapter;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void setUp() {
        consoleAdapter = new ConsoleAdapter() {
            private String input;

            public void setInput(String input) {
                this.input = input;
            }

            @Override
            public String readLine() {
                return this.input;
            }
        };
        winningNumberInputManager = WinningNumberInputManager.getInstance();
        winningNumberInputManager.setConsoleAdapter(consoleAdapter);
    }

    @Test
    void testValidInput() {
        consoleAdapter.setInput("1,2,3,4,5,6");
        List<Integer> result = winningNumberInputManager.input();
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void testNoInput() {
        consoleAdapter.setInput(null);
        assertThatThrownBy(() -> winningNumberInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void testInvalidRange() {
        consoleAdapter.setInput("1,2,3,4,5,55");
        assertThatThrownBy(() -> winningNumberInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}