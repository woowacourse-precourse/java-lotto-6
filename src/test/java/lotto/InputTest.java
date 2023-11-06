package lotto;

import java.util.List;
import lotto.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputTest {
    @DisplayName("입력 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createPaymentWithNonNumericInput() {
        assertThatThrownBy(() -> new Input().numberToInteger("12a"))
              .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersWithNonNumericInput() {
        List<String> winningNumbers = List.of("1","2","a");
        assertThatThrownBy(() -> new Input().lottoToInteger(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
