package lotto.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

            @Override
            public void close() {
                super.close();
            }
        };
        paymentInputManager=new PaymentInputManager();
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
                .hasMessageContaining("1000원 단위로 입력해주세요.");
    }

    @Test
    void testNonNumericInput() {
        consoleAdapter.setInput("abc");
        assertThatThrownBy(() -> paymentInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @Test
    void testNoInput() {
        consoleAdapter.setInput("");
        assertThatThrownBy(() -> paymentInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }
}