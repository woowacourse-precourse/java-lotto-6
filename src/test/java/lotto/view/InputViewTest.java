package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.validator.GlobalValidator.validateBlank;
import static lotto.validator.WinningNumbersValidator.validateCommaAtStartOrEnd;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setup() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", ",1,2", "1,2,3,"})
    @DisplayName("잘못된 초기 입력값은 예외를 발생시킨다.")
    public void validateInputTest(String input) {
        assertThatThrownBy(() -> validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    private void validate(String input) {
        validateBlank(input);
        validateCommaAtStartOrEnd(input);
    }


}