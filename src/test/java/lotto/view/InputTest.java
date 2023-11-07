package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.input.HasSpaceException;
import lotto.exception.input.NotIntegerException;
import lotto.exception.input.NullInputException;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {
    @DisplayName("금액 입력이 공백일 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void inputNull(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputPrice(input))
                .isInstanceOf(NullInputException.class);
    }

    @DisplayName("금액 입력이 숫자가 아닐 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","-",".","1.0","8,000"})
    void inputNotInteger(String input){
        assertThatThrownBy(() -> InputValidator.validateInputPrice(input))
                .isInstanceOf(NotIntegerException.class);
    }

    @DisplayName("금액 입력에 공백이 포함될 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 100", "11 00"})
    void inputHasSpace(String input){
        assertThatThrownBy(() -> InputValidator.validateInputPrice(input))
                .isInstanceOf(HasSpaceException.class);
    }
    @DisplayName("당첨숫자 입력이 공백일 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ","" })
    void numbersInputIsNull(String input){
        assertThatThrownBy(() -> InputValidator.validateInputNumbers(input))
                .isInstanceOf(NullInputException.class);
    }

    @DisplayName("당첨 숫자들 입력이 숫자가 아닐 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","1,a","a,b","1,2,3,a"})
    void numbersInputNotInteger(String input){
        assertThatThrownBy(() -> InputValidator.validateInputNumbers(input))
                .isInstanceOf(NotIntegerException.class);
    }

    @DisplayName("당첨 숫자들 입력에 공백이 포함될 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3, 4", " ,1,2,3", "1 0,11,12"})
    void numbersInputHasSpace(String input){
        assertThatThrownBy(() -> InputValidator.validateInputNumbers(input))
                .isInstanceOf(HasSpaceException.class);
    }



}
