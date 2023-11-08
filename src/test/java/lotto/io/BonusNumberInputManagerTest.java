package lotto.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberInputManagerTest {
    private BonusNumberInputManager bonusNumberInputManager;
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
        bonusNumberInputManager =BonusNumberInputManager.getInstance();
        bonusNumberInputManager.setConsoleAdapter(consoleAdapter);
    }
    @Test
    void testValidInput() {
        consoleAdapter.setInput("3");
        Integer result = bonusNumberInputManager.input();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testNoInput() {
        consoleAdapter.setInput(null);
        assertThatThrownBy(() -> bonusNumberInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void testInvalidRange() {
        consoleAdapter.setInput("77");
        assertThatThrownBy(() -> bonusNumberInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}