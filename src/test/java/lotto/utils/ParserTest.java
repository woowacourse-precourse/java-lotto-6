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
    @ValueSource(strings = {"."," ","s", "100s", "ss00s"})
    @DisplayName("[EXCEPTION] 숫자 형태의 input이 아니면 예외가 발생한다.")
    public void parsePayByNonNumericForm(String input){

        assertThatThrownBy(()->Parser.parsePay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자형태여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"8000,8000","12000,12000"})
    @DisplayName("[SUCCESS] 숫자 형태의 input이면 숫자로 parsing된 값을 반환한다.")
    public void parsePayByNumericForm(String input, int expected){

        assertThat(Parser.parsePay(input)).isEqualTo(expected);
    }

}