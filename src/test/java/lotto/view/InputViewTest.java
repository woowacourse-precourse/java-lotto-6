package lotto.view;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("입력 값이 빈 값일 때 예외 처리 테스트")
    void input_validate_when_blank() {
        assertThatThrownBy(() -> inputValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값이 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource({"a00","0+0","00ㅁ","최준수"})
    @DisplayName("입력값에 숫자 이외의 값이 있을 떄 예외 처리 테스트")
    void input_validate_when_non_number(String test) {
        assertThatThrownBy(() -> inputValidator.validate(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값에 숫자 이외의 값이 들어오면 안됩니다.");
    }

    @ParameterizedTest
    @CsvSource({"00","0100","00000000"})
    @DisplayName("입력값이 두 자리 수 이상이고, 첫 글자가 0으로 시작할 때 예외 처리 테스트")
    void input_validate_when_starts_with_zero(String test) {
        assertThatThrownBy(() -> inputValidator.validate(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값이 두자리 수 이상일 때 첫 글자가 0이면 안됩니다.");
    }

    @Test
    @DisplayName("입력값이 정수의 범위를 넘어갈 때 예외 처리 테스트")
    void input_validate_when_out_of_integer_range(){
        assertThatThrownBy(() -> inputValidator.validate("2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 정수 값을 입력하세요.");
    }

    @Test
    @DisplayName("입력값이 0보다 작을 때 예외 처리 테스트")
    void input_validate_when_less_than_zero() {
        assertThatThrownBy(() -> inputValidator.validate("-9999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 작을 수 없습니다.");
    }

}