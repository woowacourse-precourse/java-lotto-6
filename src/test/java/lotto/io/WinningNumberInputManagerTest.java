package lotto.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumberInputManagerTest {
    private WinningNumberInputManager winningNumberInputManager;
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
        winningNumberInputManager =WinningNumberInputManager.getInstance();
        winningNumberInputManager.setConsoleAdapter(consoleAdapter);
    }

    @Test
    void testValidInput() {
        consoleAdapter.setInput("1,2,3,4,5,6");
        List<Integer> result = winningNumberInputManager.input();
        assertThat(result).isEqualTo(List.of(1,2,3,4,5,6));
    }
    @Test
    void testInvalidInput() {
        consoleAdapter.setInput("1.2.3,4,5,6");
        assertThatThrownBy(() -> winningNumberInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }
    @Test
    void testNoInput() {
        consoleAdapter.setInput(null);
        assertThatThrownBy(() -> winningNumberInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 존재하지 않습니다.");
    }

    @Test
    void testInvalidRange() {
        consoleAdapter.setInput("1,2,3,4,5,55");
        assertThatThrownBy(() -> winningNumberInputManager.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 범위 내의 값을 입력해주세요.");
    }
}