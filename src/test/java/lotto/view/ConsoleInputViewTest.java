package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static lotto.exception.errorcode.InputErrorCode.INPUT_NOT_NUMERIC;
import static lotto.exception.errorcode.InputErrorCode.INPUT_SPLIT_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleInputViewTest {
    private InputStream inputStream;
    private final InputView inputView = new ConsoleInputView();

    @AfterEach
    public void afterEach() throws IOException {
        Console.close();
    }

    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    public void requestPurchasePriceNotNumeric() throws Exception {
        initInputStream("123A");
        assertThatThrownBy(inputView::requestPurchasePrice)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NOT_NUMERIC.getMessage());
    }

    @DisplayName("당첨 번호를 쉼표(,)로 분할 시 6개가 아닌 경우 예외가 발생한다.")
    @Test
    public void requestWinningNumberInvalidSplitSize() throws Exception {
        initInputStream("1,2,3,4,5,6,7");
        assertThatThrownBy(inputView::requestWinningNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_SPLIT_SIZE.getMessage());
    }

    @DisplayName("분할한 당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    public void requestWinningNumberNotNumeric() throws Exception {
        initInputStream("1,2,3,4,5,A");
        assertThatThrownBy(inputView::requestWinningNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NOT_NUMERIC.getMessage());
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    public void requestBonusNumberNotNumeric() throws Exception {
        initInputStream("A");
        assertThatThrownBy(inputView::requestBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NOT_NUMERIC.getMessage());
    }

    private void initInputStream(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}