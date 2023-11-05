package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
}
