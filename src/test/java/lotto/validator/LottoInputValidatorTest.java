package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoInputValidatorTest {

    private static InputValidator validator;

    @BeforeEach
    void beforeAll() {
        validator = new LottoInputValidator();
    }

    @ParameterizedTest
    @DisplayName("로또번호 입력: 숫자외의 문자가 포함된 경우")
    @ValueSource(strings = {"1,a,b,c,d,e", "1, ,2,3,4,5", "1, 2, 3, 4, 5, 6"})
    void whenInputContainsNonInteger(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("로또번호 입력: 범위에서 벗어난 숫자가 있는 경우")
    @ValueSource(strings = {"1,60,10,2,3", "0,1,2,3,4,5"})
    void whenInputContainsOutRangeNumber(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("로또번호 입력: 중복된 숫자가 있는 경우")
    @ValueSource(strings = {"1,5,5,6,6,6", "1,2,3,4,5,1"})
    void whenInputContainsDuplicateNumber(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("로또번호 입력: 길이가 6이 아닌 경우")
    @ValueSource(strings = {"1,2,3,4", "1,2,3,4,5,6,7"})
    void whenInputLengthIsNot6(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("로또번호 입력: ,가 연속해서 나올 경우")
    @ValueSource(strings = {"1,2,,5,6,7"})
    void whenCommasAreSequential(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("구입금액: 올바른 입력이 들어왔을 때")
    @ValueSource(strings = {"10,23,31,14,25,36"})
    void whenInputIsValid(String input) {
        validator.validate(input);
    }
}