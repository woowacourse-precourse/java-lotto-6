package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

class InputViewTest {


    final InputView inputView = InputView.getInstance();
    private void setIn(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @DisplayName("입력한 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"문자", " 12", "1 2", "12 "})
    void readAmountByNonNumericInput(String amount) {
        try {
            setIn(amount);
            Assertions.assertThatThrownBy(inputView::readAmount)
                    .isInstanceOf(IllegalArgumentException.class);
        } finally {
            Console.close();
        }
    }
}
