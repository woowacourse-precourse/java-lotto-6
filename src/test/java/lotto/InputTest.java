package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputTest {
    @DisplayName("구입 금액 입력시 숫자가 아닌값이 입력되면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        System.setIn(createUserInput("2000r"));
        assertThatThrownBy(InputView::askPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

