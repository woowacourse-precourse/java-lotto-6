package controller.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

import static org.assertj.core.api.Assertions.*;


class WinningNumberValidatorTest extends NsTest {
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

    @DisplayName("올바르지 않은 형식으로 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {",,1,2,3", ",,,", ",,1,2", "1,2,3,4,5,6,,", "1,2,3,4,5,6,"})
    void wrongInputFormat(String input) {
        assertThatThrownBy(() -> winningNumberValidator.checkWinningNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.INCORRECT_WINNING_NUMBER_FORMAT.getErrorMessage());
    }

    @DisplayName("입력된 당첨 번호의 개수가 6개 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings ={"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void winningNumberIsNotSix(String input) {
        assertThatThrownBy(() -> winningNumberValidator.checkWinningNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.LOTTO_MUST_CONTAIN_SIX_NUMBERS.getErrorMessage());
    }

    @DisplayName("당첨 번호에 숫자가 아닌 다른 문자 포함 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings ={"a,b,c,d,e,f", "1,a,2,b,3,c", "Q,W,E,R,T,Y"})
    void winningContainCharacter(String input) {
        assertThatThrownBy(() -> winningNumberValidator.checkWinningNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.LOTTO_MUST_BE_COMPOSED_OF_NUMBER.getErrorMessage());
    }

    @DisplayName("당첨 번호에 로또 번호 범위를 벗어난 숫자 포함 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings ={"-1,2,3,4,5,6", "46,47,48,49,50,51"})
    void winningNumberOutOfRange(String input) {
        assertThatThrownBy(() -> winningNumberValidator.checkWinningNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getErrorMessage());
    }

    @DisplayName("당첨 번호에 중복된 번호 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5","7,7,7,7,7,7"})
    void winningNumberContainDuplicateNumber(String input) {
        assertThatThrownBy(() -> winningNumberValidator.checkWinningNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.LOTTO_CONTAIN_DULPICATE_NUMBER.getErrorMessage());
    }

    @Override
    public void runMain(){
    }
}