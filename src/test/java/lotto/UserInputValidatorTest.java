package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.UserInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "32@1", " 3000"})
    @DisplayName("숫자가 아닌 문자가 입력되는 경우 예외처리")
    void throwExceptionWhenInputIsNotNumber(String value) {
        assertThatThrownBy(() -> UserInputValidator.validateNum(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로만 입력해주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("빈칸이나 null값 전달하면 예외처리")
    void throw_IllegalException_when_input_isNullOrBlank(String value) {
        assertThatThrownBy(() -> UserInputValidator.validateNull(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 값을 입력할 수 없습니다.");
    }


    @DisplayName("당첨번호에 구분자 , 가 아니면 예외처리")
    @Test
    void throw_when_input_isNotSeperator() {
        assertThatThrownBy(() -> UserInputValidator.validateWinningLotto("1,2,3,4&5&6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 번호 입니다" + "공백없이 구분자 ,를 넣어 입력하세요.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2, ,4,5,6", "", "1,2,,3,4,5"})
    @DisplayName("당첨번호에 공백이 포함되거나 공백이 입력되면 예외처리")
    void throw_when_input_contain_space(String value) {
        assertThatThrownBy(() -> UserInputValidator.validateWinningLotto(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 번호 입니다" + "공백없이 구분자 ,를 넣어 입력하세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,42"})
    @DisplayName("당첨번호 정상적으로 입력하면 통과되는 지 확인")
    void normal_input_winningNumbers(String value) {
        assertThatCode(() -> UserInputValidator.validateWinningLotto(value))
                .doesNotThrowAnyException();
    }

}