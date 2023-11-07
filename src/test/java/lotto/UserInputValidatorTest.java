package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    @DisplayName("숫자가 아닌 문자가 입력되는 경우 예외처리")
    @Test
    void throwExceptionWhenInputIsNotNumber() {
        assertThatThrownBy(() -> UserInputValidator.validateNum("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로만 입력해주세요");

        assertThatThrownBy(() -> UserInputValidator.validateNum("32@1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로만 입력해주세요");

        assertThatThrownBy(() -> UserInputValidator.validateNum(" 3000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자로만 입력해주세요");
    }

    @DisplayName("빈칸이나 null값 전달하면 예외처리")
    @Test
    void throw_IllegalException_when_input_isNullOrBlank() {
        assertThatThrownBy(() -> UserInputValidator.validateNull(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 값을 입력할 수 없습니다.");

        assertThatThrownBy(() -> UserInputValidator.validateNull(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 값을 입력할 수 없습니다.");

        assertThatThrownBy(() -> UserInputValidator.validateNull(null))
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

    @DisplayName("당첨번호에 공백이 포함되거나 공백이 입력되면 예외처리")
    @Test
    void throw_when_input_contain_space() {
        assertThatThrownBy(() -> UserInputValidator.validateWinningLotto("1,2, ,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 번호 입니다" + "공백없이 구분자 ,를 넣어 입력하세요.");

        assertThatThrownBy(() -> UserInputValidator.validateWinningLotto(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 번호 입니다" + "공백없이 구분자 ,를 넣어 입력하세요.");

        assertThatThrownBy(() -> UserInputValidator.validateWinningLotto("1,2,,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 번호 입니다" + "공백없이 구분자 ,를 넣어 입력하세요.");


    }

    @DisplayName("당첨번호 정상적으로 입력하면 통과되는 지 확인")
    @Test
    void normal_input_winningNumbers() {
        assertThatCode(() -> UserInputValidator.validateWinningLotto("1,2,3,4,5,6"))
                .doesNotThrowAnyException();

        assertThatCode(() -> UserInputValidator.validateWinningLotto("1,2,3,4,5,42"))
                .doesNotThrowAnyException();
    }

}