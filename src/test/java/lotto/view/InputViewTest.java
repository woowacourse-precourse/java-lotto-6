package lotto.view;

import static lotto.constants.ErrorMessage.ERROR_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private final InputView sample = new InputView();

    @ParameterizedTest
    @DisplayName("입력된 문자열에 빈 문자열 혹은 공백문자가 사용된 문자열 입력 시, 에러 메시지 발생(공통 유효성 검사)")
    @ValueSource(strings = {"", "  ", "1 000"})
    void validateInput_test(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validateInput(input));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
        assertThatCode(() -> sample.validateInput("1000")).doesNotThrowAnyException();
        assertThatCode(() -> sample.validateInput("1")).doesNotThrowAnyException();
        assertThatCode(() -> sample.validateInput("45")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("입력된 당첨번호가 빈 문자열이거나, 공백문자가 사용되었거나, 쉼표(,)를 잘못 사용했을 시 에러메시지 발생")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 6", "1,,2,3,4,5,6", ",1,2,3,4,5,6",
            "1,2,3,4,5,6,", " 1,2,3,4,5,6", "1,2,3,4,5,6 "
    })
    void validateInputWInnerNum_test(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validateInputWinnerNum(input));
        assertThat(exception.getMessage()).contains(ERROR_FORMAT);
        assertThatCode(() -> sample.validateInputWinnerNum("1,2,3,4,5,6")).doesNotThrowAnyException();
    }
}