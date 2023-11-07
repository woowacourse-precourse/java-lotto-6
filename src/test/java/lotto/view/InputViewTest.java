package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("번호와 번호 사이에 ','이 아닌 다른 문자가 들어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1,,3,4,5,6", "1,2,a,b,5,6"})
    void checkInputWinningNumber(String inputWinningNumber) {
        Assertions.assertThatThrownBy(() -> InputView.stringToList(inputWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
