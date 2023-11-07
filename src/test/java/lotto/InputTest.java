package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTest {
    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @DisplayName("아무 입력도 하지않으면 에러가 발생한다.")
    @Test
    void inputPurchaseAmountByBlank() {
        String inputString = "";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 정수가 아니면 에러가 발생한다.")
    @Test
    void inputPurchaseAmountByString() {
        String inputString = "bad";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 정수가 아니면 에러가 발생한다.")
    @Test
    void inputPurchaseAmountByInvalidValue() {
        String inputString = "11001";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}