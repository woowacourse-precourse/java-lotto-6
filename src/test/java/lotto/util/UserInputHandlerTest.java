package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.TestDefault;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputHandlerTest extends TestDefault {
    @DisplayName("로또 구입 금액을 정상적으로 입력 했을때 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void testLottoPurchaseAmountInputSuccess(String userInput) {
        Integer expected = Integer.parseInt(userInput);
        setInputs(userInput);

        Integer amount = UserInputHandler.getLottoPurchaseAmount();

        assertThat(amount).isEqualTo(expected);
    }

    @DisplayName("로또 구입 금액을 숫자 말고 다른걸 입력 했을때 예외 출력후 다시 입력이 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "test", "!@"})
    void testLottoPurchaseAmountInputNumericException(String userInput) {
        String nextInput = "1000";

        setInputs(userInput, nextInput);

        assertThat(UserInputHandler.getLottoPurchaseAmount()).isEqualTo(Integer.parseInt(nextInput));
    }

    @DisplayName("로또 번호를 정상적으로 입력 했을때 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "7,8,9,10,11,12"})
    void testLottoNumbersInputSuccess(String userInput) {
        List<Integer> expected = Arrays.stream(userInput.split(",")).map(e -> Integer.parseInt(e)).toList();
        setInputs(userInput);

        List<Integer> winningNumbers = UserInputHandler.getWinningNumbers();

        assertThat(winningNumbers).isEqualTo(expected);
    }

    @DisplayName("로또 번호를 숫자 말고 다른걸 입력 했을때 예외 출력후 다시 입력이 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "test", "!@", "1,a,3,b,7,8"})
    void testLottoNumbersInput(String userInput) {
        String nextInput = "1,2,3,4,5,6";
        List<Integer> expected = Arrays.stream(nextInput.split(",")).map(e -> Integer.parseInt(e)).toList();

        setInputs(userInput, nextInput);

        assertThat(UserInputHandler.getWinningNumbers()).isEqualTo(expected);
    }
}