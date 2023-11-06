package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.exception.ExceptionMessage.NULL_POINTER_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import lotto.validator.InputValidator;
import lotto.view.InputView;

public class InputTest {

    private InputView inputView = new InputView();
    private InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @CsvSource(value = {"   공 백 테 스트,공백테스트", "  공백 테스   트,공백테스트"})
    @DisplayName("공백 제거 정상적으로 작동하는 지 테스트")
    public void 공백_제거_테스트(String input, String expected) {
        assertThat(inputView.removeWhitespace(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력에 Null값이 들어가는 경우")
    public void Null_입력_예외(String input) {
        assertThatThrownBy(() -> inputValidator.validateNotNull(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(NULL_POINTER_EXCEPTION_MESSAGE.getMessage());
    }


}
