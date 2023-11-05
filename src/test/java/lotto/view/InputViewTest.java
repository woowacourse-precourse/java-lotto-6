package lotto.view;

import static lotto.message.InputErrorMessage.INVALID_INPUT_FORMAT;
import static lotto.message.InputErrorMessage.INVALID_INPUT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest{
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }
    @DisplayName("구입 금액에서 숫자가 아닌 다른 값을 입력하면 예외를 발생시킨다.")
    @Test
    void requestLottoPurchaseAmountByNotNumber() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "test";
            systemIn(inputValue);
            inputView.requestLottoPurchaseAmount();
            assertThat(output()).contains(String.format(INVALID_INPUT_FORMAT, "숫자"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에서 1,000 단위가 아닌 값을 입력하면 예외를 발생시킨다.")
    @Test
    void requestLottoPurchaseAmountByNotInvalidUnit() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "1234123141";
            systemIn(inputValue);
            inputView.requestLottoPurchaseAmount();
            assertThat(output()).contains(INVALID_INPUT_UNIT);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에서 0 보다 작은 값을 입력하면 예외를 발생시킨다.")
    @Test
    void requestLottoPurchaseAmountByNegative() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "-12000";
            systemIn(inputValue);
            inputView.requestLottoPurchaseAmount();
            assertThat(output()).contains(INVALID_INPUT_UNIT);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void systemOut() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }
}