package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {

    @DisplayName("빈 문자열을 입력하면 에외를 발생시킨다.")
    @Test
    void emptyStringThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("공백으로된 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void blankStringThrowException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백으로만 이루어진 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("숫자와 구분자로만 이루어지지 않은 문자열을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.7.8.9.2.4", "1%7%8.9.2.4", "1/7/8/9/2/4", "1 7 8 9 2 4"})
    void onlyNotNumberAndDelimiterThrowIllegalArgumentException(String input) {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 ,와 숫자로 구성된 문자열만을 입력할 수 있습니다.");
    }

    @DisplayName("숫자와 구분자로만 이루어지진 문자열을 입력하면 예외를 발생시키지 않는다.")
    @Test
    void onlyNumberAndDelimiterNotThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertDoesNotThrow(() -> lottoNumberValidator.validateLottNumbers("1,3,4,5,6,9"));
    }

    @DisplayName("구분자로 시작하는 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void startsWithDelimiterThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(",1,3,2,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자인 ,로 시작하는 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("구분자로 끝나는 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void endsWithDelimiterThrowIllegalArgumentException() {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("1,3,4,2,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자인 ,로 끝나는 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("연속적인 구분자가 있는 문자열을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"24,,,7,6,,,5", "24,,7,6,,5", "24,7,6,,5,45"})
    void consecutiveDelimiterThrowIllegalArgumentException(String input) {
        //given
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();

        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 ,를 연속해서 입력할 수 없습니다.");
    }

}