package lotto.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberInputManagerTest {
    private BonusNumberInputManager bonusNumberInputManager;
    private ConsoleAdapter consoleAdapter;
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
}