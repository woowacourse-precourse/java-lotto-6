package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @BeforeEach
    void resetBuffer() {
        Console.close();
    }

    @Test
    @DisplayName("구입금액을 입력받는다.")
    void getPurchaseAmount() {
        setInput("8000");
        InputView.getPurchaseAmount();
    }

    @Test
    @DisplayName("구입금액이 정수가 아니면 예외를 발생한다.")
    void getPurchaseAmountWithNotInteger() {
        setInput("팔천원");
        assertThatThrownBy(() -> InputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액이 정수가 아니면 예외를 발생한다.")
    void getPurchaseAmountWithNotPositiveInteger() {
        setInput("-2000");
        assertThatThrownBy(() -> InputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void setInput(String input) {
        final byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}