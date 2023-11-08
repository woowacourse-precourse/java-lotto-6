package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,c,d,5,6", "1.2.3.4.5.6"})
    @DisplayName("올바르지 않은 입력 값")
    void failed(String inputWinningNumber) {
        assertThatThrownBy(() -> InputView.numberList(inputWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
