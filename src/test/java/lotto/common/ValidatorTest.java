package lotto.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @DisplayName("Null 또는 공백이 포함되지 않는 문자열은 예외가 발생하지 않는다.")
    @ParameterizedTest(name = "[{index}차]시도: string: {0}")
    @ValueSource(strings = {"phobi", "guap", "nike", "James"})
    void testVerifyNullAndBlank(String string) {
        //given
        //when
        validator.verifyNullAndBlank(string);
        //then
    }

    @DisplayName("Null 또는 공백이 포함될 경우 IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: string: {0}")
    @ValueSource(strings = {"string  -", "s tring", "i ", "d1 233"})
    @NullAndEmptySource
    void failVerifyNullAndBlank(String string) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> validator.verifyNullAndBlank(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 숫자형식으로 변경할 떄 NumberFormatException 이 발생하지 않으면 예외가 발생하지 않는다.")
    @ParameterizedTest(name = "[{index}차]시도: string: {0}")
    @ValueSource(strings = {"123123123", "111", "1", "0"})
    void testVerifyNumber(String string) {
        //given
        //when
        validator.verifyNumber(string);
        //then
    }

    @DisplayName("문자열을 숫자형식으로 변경할 떄 NumberFormatException 발생하면 IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: string: {0}")
    @ValueSource(strings = {"123d", "11 1", "123  ", "d1233"})
    @NullAndEmptySource
    void failVerifyNumber(String string) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> validator.verifyNumber(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[start~end] 범위에 포함된 경우 예외가 발생하지 않는다.")
    @ParameterizedTest(name = "[{index}차]시도: minimumValue: {0}, maximumValue: {1}")
    @CsvSource({"1,2,1", "2,3,3", "2,2,2", "1,1,1", "1,100,99"})
    void testVerifyInRangeClosed(int start, int end, int rangedValue) {
        //given
        //when
        validator.verifyInRangeClosed(start, end, rangedValue);
        //then
    }

    @DisplayName("[start~end] 범위를 벗어난 경우  IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: minimumValue: {0}, maximumValue: {1}")
    @CsvSource({"1,2,3", "2,3,4", "2,2,1", "1,1,-1", "1,100,101"})
    void failVerifyInRangeClosed(int start, int end, int outOfValue) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> validator.verifyInRangeClosed(start, end, outOfValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}