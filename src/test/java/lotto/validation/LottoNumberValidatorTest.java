package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {

    private LottoNumberValidator lottoNumberValidator;

    @BeforeEach
    void createLottoNumberValidator() {
        this.lottoNumberValidator = new LottoNumberValidator();
    }

    @DisplayName("빈 문자열을 입력하면 에외를 발생시킨다.")
    @Test
    void emptyStringThrowIllegalArgumentException() {
        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("공백으로된 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void blankStringThrowException() {
        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백으로만 이루어진 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("숫자와 구분자로만 이루어지지 않은 문자열을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.7.8.9.2.4", "1%7%8.9.2.4", "1/7/8/9/2/4", "1 7 8 9 2 4"})
    void onlyNotNumberAndDelimiterThrowIllegalArgumentException(String input) {
        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자 ,와 숫자로 구성된 문자열만을 입력할 수 있습니다.");
    }

    @DisplayName("숫자와 구분자로만 이루어지진 문자열을 입력하면 예외를 발생시키지 않는다.")
    @Test
    void onlyNumberAndDelimiterNotThrowIllegalArgumentException() {
        //when, then
        assertDoesNotThrow(() -> lottoNumberValidator.validateLottNumbers("1,3,4,5,6,9"));
    }

    @DisplayName("구분자로 시작하는 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void startsWithDelimiterThrowIllegalArgumentException() {
        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(",1,3,2,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자인 ,로 시작하는 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("구분자로 끝나는 문자열을 입력하면 예외를 발생시킨다.")
    @Test
    void endsWithDelimiterThrowIllegalArgumentException() {
        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers("1,3,4,2,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자인 ,로 끝나는 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("연속적인 구분자가 있는 문자열을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"24,,,7,6,,,5", "24,,7,6,,5", "24,7,6,,5,45"})
    void consecutiveDelimiterThrowIllegalArgumentException(String input) {
        //when, then
        assertThatThrownBy(() -> lottoNumberValidator.validateLottNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자 ,를 연속해서 입력할 수 없습니다.");
    }

    @DisplayName("보너스 번호를 빈 문자열로 입력하면 에외를 발생시킨다.")
    @Test
    void emptyBonusNumberThrowIllegalArgumentException() {
        //when, then
        assertThatThrownBy(
                () -> lottoNumberValidator.validateBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("보너스 번호를 공백으로 입력하면 예외를 발생시킨다.")
    @Test
    void blankBonusNumberThrowException() {
        //when, then
        assertThatThrownBy(
                () -> lottoNumberValidator.validateBonusNumber("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백으로만 이루어진 문자열을 입력할 수 없습니다.");
    }

    @DisplayName("숫자와 구분자로만 이루어지지 않은 문자열을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.7.8.9.2.4", "1%7%8.9.2.4", "1/7/8/9/2/4", "1 7 8 9 2 4"})
    void notNumberThrowIllegalArgumentException(String input) {
        //when, then
        assertThatThrownBy(
                () -> lottoNumberValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력할 수 있습니다.");
    }

}