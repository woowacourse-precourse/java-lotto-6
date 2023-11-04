package lotto.ValidatorTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.Validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("정상적인 입력을 했을 경우 true를 반환하는가?")
    @ParameterizedTest
    @CsvSource({"'1,2,3,4,5,6', true",
                "'1,3,5,7,6,3', true"})
    void isNumberTest(String input, boolean expected){
        System.out.println(input);
        boolean real = InputValidator.isNumber(input);
        assertThat(real).isEqualTo(expected);

    }

    @DisplayName("숫자가 아닌 다른 문자를 입력했을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a,2,1,3,4,b", "1,3,6,2,a,h", "^,1,2,3,!,5"})
    void isNumberTest(String nonNumber){
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isNumber(nonNumber);
        });
    }

    @DisplayName("숫자가 아닌 다른 문자를 입력했을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"22,2,10,3,4!1", "1,3@,4,6,2,10;23"})
    void checkCommaDelimiter(String nonNumber){
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkCommaDelimiter(nonNumber);
        });
    }
}
