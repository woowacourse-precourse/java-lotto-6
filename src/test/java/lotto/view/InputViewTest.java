package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

public class InputViewTest {

    @DisplayName("구입 금액을 1000원 단위로 올바르게 입력 시 long 타입으로 return한다.")
    @Test
    public void testInputNumberOfLottosWithValidInput() {
        InputView.setInputForTesting("10000");
        long result = InputView.inputPurchaseAmount();
        assertEquals(10000, result);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    public void testInputNumberOfLottosWithInvalidInput() {
        InputView.setInputForTesting("abc"); // 잘못된 입력
        assertThrows(IllegalArgumentException.class, () -> InputView.inputPurchaseAmount());
    }

    @DisplayName("구입 금액을 1000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    public void testInputNumberOfLottosWithInValidInput() {
        InputView.setInputForTesting("100001");
        assertThrows(IllegalArgumentException.class, () -> InputView.inputPurchaseAmount());
    }

    @DisplayName("당첨 번호를 올바르게 입력 시 List<Integer> 타입으로 return한다.")
    @Test
    public void testInputWinningNumbersWithValidInput() {
        InputView.setInputForTesting("1,2,3,4,5,6");
        List<Integer> result = InputView.inputWinningNumbers();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }

    @DisplayName("당첨 번호 입력이 잘못되면 예외가 발생한다.")
    @Test
    public void testInputWinningNumbersWithInvalidInput() {
        InputView.setInputForTesting("1,2,3,4,5,100"); // 잘못된 입력 (범위 초과)
        assertThrows(IllegalArgumentException.class, () -> InputView.inputWinningNumbers());

        InputView.setInputForTesting("1,2,3,4,5,30,10"); // 잘못된 입력 (입력 숫자 개수 초과)
        assertThrows(IllegalArgumentException.class, () -> InputView.inputWinningNumbers());

        InputView.setInputForTesting("1,2,3,4,5,5"); // 잘못된 입력 (중복)
        assertThrows(IllegalArgumentException.class, () -> InputView.inputWinningNumbers());

        InputView.setInputForTesting("1,2,3,4,5,abc"); // 잘못된 입력 (숫자 형식 아님)
        assertThrows(IllegalArgumentException.class, () -> InputView.inputWinningNumbers());
    }
}
