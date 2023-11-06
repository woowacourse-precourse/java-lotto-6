package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class InputViewTest {


    final InputView inputView = InputView.getInstance();
    private void setIn(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @DisplayName("입력한 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void readAmountByNonNumericInput() {
        setIn("문자");
        Assertions.assertThatThrownBy(inputView::readAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
