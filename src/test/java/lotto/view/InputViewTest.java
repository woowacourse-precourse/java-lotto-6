package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "ㄱ", "", " ", ","})
    @DisplayName("구매 금액 숫자가 아닌 것을 입력 시 ")
    void inputNonNumericAmount(String input) {
        assertThatThrownBy(() -> InputView.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ㄱ", "1.2.3.4.5.6", "1 2 3 4 5 6", "", " "})
    @DisplayName("로또 당첨 번호 입력 형식이 아닌 것을 입력 시 ")
    void inputInvalidWinningNumbers(String input) {
        assertThatThrownBy(() -> InputView.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ㄱ", "", " ", ","})
    @DisplayName("로또 보너스 번호 숫자가 아닌 것을 입력 시 ")
    void inputInvalidBonusNumber(String input) {
        assertThatThrownBy(() -> InputView.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
