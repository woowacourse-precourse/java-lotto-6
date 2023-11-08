package lotto.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentInputManagerTest {
    private PaymentInputManager paymentInputManager;
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
        paymentInputManager = PaymentInputManager.getInstance();
        paymentInputManager.setConsoleAdapter(consoleAdapter);
    }

    @Test
    void testValidInput() {
        consoleAdapter.setInput("3000");
        Integer result = paymentInputManager.input();
        assertThat(result).isEqualTo(3);
    }
}