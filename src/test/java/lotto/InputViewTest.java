package lotto;

import java.util.List;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputViewTest {
    @DisplayName("입력 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createPaymentWithNonNumericInput() {
        assertThatThrownBy(() -> new InputView().paymentToInteger("12a"))
              .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersWithNonNumericInput() {
        List<String> winningNumbers = List.of("1","2","a");
        assertThatThrownBy(() -> new InputView().winningNumbersToInteger(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
