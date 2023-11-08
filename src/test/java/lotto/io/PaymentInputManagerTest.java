package lotto.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentInputManagerTest {
    private PaymentInputManager paymentInputManager;
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
        paymentInputManager = PaymentInputManager.getInstance();
        paymentInputManager.setConsoleAdapter(consoleAdapter);
    }

    @Test
    void testValidInput() {
        consoleAdapter.setInput("3000");
        Integer result = paymentInputManager.input();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testInputNotMultipleOfThousand() {
        consoleAdapter.setInput("2500");
        assertThatThrownBy(() -> paymentInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void testNonNumericInput() {
        consoleAdapter.setInput("abc");
        assertThatThrownBy(() -> paymentInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void testNoInput() {
        consoleAdapter.setInput("");
        assertThatThrownBy(() -> paymentInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}