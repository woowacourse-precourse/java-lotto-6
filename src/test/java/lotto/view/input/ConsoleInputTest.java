package lotto.view.input;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleInputTest {

    private final Input consoleInput = new ConsoleInput();

    @DisplayName("로또 구매 금액을 숫자가 아닌 값을 입력 시 예외가 발생한다.")
    @Test
    void inputPurchaseAmount() {
        //given
        String purchaseAmountInput = "123a";
        InputStream input = new ByteArrayInputStream(purchaseAmountInput.getBytes());
        System.setIn(input);

        //when //then
        Assertions.assertThatThrownBy(consoleInput::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("숫자가 아닌 로또 당첨 번호를 입력할 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbers() {
        //given
        String purchaseAmountInput = "1, 2, 3, a";
        InputStream input = new ByteArrayInputStream(purchaseAmountInput.getBytes());
        System.setIn(input);
    
        //when //then
        Assertions.assertThatThrownBy(consoleInput::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
