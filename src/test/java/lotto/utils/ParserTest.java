package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {".", " ", "s", "100s", "ss00s"})
    @DisplayName("[EXCEPTION] 숫자 형태의 input이 아니면 예외가 발생한다.")
    public void parsePayByNonNumericForm(String input) {

        assertThatThrownBy(() -> Parser.parsePay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자형태여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"8000,8000", "12000,12000"})
    @DisplayName("[SUCCESS] 숫자 형태의 input이면 숫자로 parsing된 값을 반환한다.")
    public void parsePayByNumericForm(String input, int expected) {

        assertThat(Parser.parsePay(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,S", "1,2,3,4,5, ", "1,2,3,,4,5,6", "", " "})
    @DisplayName("[EXCEPTION] 당첨 번호가 잘못된 형태의 문자열인 경우 예외가 발생한다.")
    public void parseWinningNumbersByWrongForm(String input) {

        assertThatThrownBy(() -> Parser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 쉼표(,)로 구분된 숫자 배열이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "1,2,3,4,5,"})
    @DisplayName("[EXCEPTION] 당첨 번호가 쉼표(,)로 끝나는 경우 예외가 발생한다.")
    public void winnngNumberEndsWithDelimiter(String input) {

        assertThatThrownBy(() -> Parser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 쉼표(,)로 끝나지 않아야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "s", "3,3"})
    @DisplayName("[EXCEPTION] 보너스 번호가 숫자 형태가 아닌 경우 예외가 발생한다.")
    public void bonusNumberByNonNumericForm(String input) {

        assertThatThrownBy(() -> Parser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}