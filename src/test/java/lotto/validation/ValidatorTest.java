package lotto.validation;

import lotto.exception.DataTypeRangeException;
import lotto.exception.IncludeCharException;
import lotto.exception.InputBlankException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {
    private final String INT_RANGE = "'2147483647'";
    private final String INT_RANGE_PLUS_ONE = "'2147483648'";

    @ParameterizedTest
    @DisplayName("[ERROR] 빈칸이 입력되었을 때")
    @CsvSource({"''", "' '", "'     '"})
    void checkBlankTest(String readLine) {
        Assertions.assertThatThrownBy(() ->
                Validator.checkBlank(readLine)).isInstanceOf(InputBlankException.class);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 숫자입력에 대해 문자를 포함하고있을 때")
    @CsvSource({"'-1'", "'가나다'", "'/'"})
    void checkDigitTest(String readLine) {
        Assertions.assertThatThrownBy(() ->
                Validator.checkDigit(readLine)).isInstanceOf(IncludeCharException.class);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 자료형 범위를 벗어났을때")
    @CsvSource({INT_RANGE_PLUS_ONE})
    void validateParseNumberTest(String readLine) {
        Assertions.assertThatThrownBy(() ->
                Validator.validateParseNumber(readLine)).isInstanceOf(DataTypeRangeException.class);
    }
}
