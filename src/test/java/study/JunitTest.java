package study;

import lotto.exception.LottoException;
import lotto.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JunitTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5, ", "sa", "!,1,2,3,4,5", " 1, 2,3,4,5,6", " 1,2,3,4,5,6 "})
    @DisplayName("csvSource 의 구분자는 콤마이고, 문자열을 trim() 한다. 첫번째 인덱스만 가지고 테스트를 한다. 성공 하더라도 잘못된 테스트")
    void 잘못된_테스트(String input) throws LottoException{
        assertThatThrownBy(() -> Validator.validatedWinningNumbersFormat(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5, ", "sa", "!,1,2,3,4,5", " 1, 2,3,4,5,6", " 1,2,3,4,5,6 "})
    @DisplayName("잘못된 테스트를 변경한 테스트")
    void 변경한_테스트(String input) throws LottoException {
        // 포맷 예시) 1,23,12,34,42,45
        assertThatThrownBy(() -> Validator.validatedWinningNumbersFormat(input))
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "   1,2,3   ", "1,2,3 ", "  1,2,3"})
    @DisplayName("ValueSource 는 문자열 그대로 반환")
    void valueSource(String input) {
        System.out.println(input);
        System.out.println(input.length());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6", "1,12,2,3,4,5", "1,2,3,4,5,6", "   1,2,3,4,5,6"})
    @DisplayName("CsvSource 기본 구분자는 콤마다. 주의!")
    void csvSourceComma(String input)  {
        System.out.println(input);
        System.out.println(input.length());
        assertThat(input).isEqualTo("1");
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1,2볼 1스트라이크", "0, 0, 0볼 0스트라이크", "3, 0, 3볼 0스트라이크"})
    @DisplayName("CsvSource 제대로 된 사용 방법")
    void csvSourceSuccess(int ball, int strike, String answer)  {
        System.out.println(ball + " " + strike + " " + answer);
        assertThat(answer).isEqualTo(ball +"볼 " + strike + "스트라이크");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "    1,2,3", "   1,2,3   "},
            delimiter = ':')
    @DisplayName("CsvSource 는 trim() 한다.")
    void csvSourceString(String input) {
        System.out.println(input);
        System.out.println(input.length());
        assertThat(input).isEqualTo("1,2,3");
    }

    @ParameterizedTest
    @CsvSource(value = {" 1, 2,   3", "  1, 2,   3 "},
            delimiter = ':')
    @DisplayName("CsvSource 중간 공백인 경우는 그대로 있다")
    void csvSourceStringTrim(String input) {
        System.out.println(input);
        System.out.println(input.length());
        assertThat(input).isEqualTo("1, 2,   3");
    }
}
