package lotto.view.validator;

import lotto.utils.message.InputExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   ", "     "})
    @DisplayName("[Exception] 공백 입력 시 예외가 발생한다.")
    void blank(String wrongInput) {
        Assertions.assertThatThrownBy(() -> WinningNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.BLANK.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"11,12,13,14,15,16,18,19", "123456789011121314151", "1234567890 1112131415"})
    @DisplayName("[Exception] 최대 길이 20을 초과할 시 예외가 발생한다.")
    void maxLength(String wrongInput) {
        Assertions.assertThatThrownBy(() -> WinningNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.EXCEED_WINNING_NUMBER_LENGTH.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5,6", ",,11,12,13,14,15,16"})
    @DisplayName("[Exception] 콤마가 맨 앞에 있을 시 예외가 발생한다.")
    void firstCharacterComma(String wrongInput) {
        Assertions.assertThatThrownBy(() -> WinningNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.FIRST_CHARACTER_COMMA.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,", "11,12,13,14,15,16,,"})
    @DisplayName("[Exception] 콤마가 맨 앞에 있을 시 예외가 발생한다.")
    void lastCharacterComma(String wrongInput) {
        Assertions.assertThatThrownBy(() -> WinningNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.LAST_CHARACTER_COMMA.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,4,5,6", "7,8,9,,10,11,12", "13,I4,15,16,17,18", "19,김,준,기,20,21",
            "21,\n,\r,\t,22,23", "김준기", "KimJunGi", "1,,,,,,,2"})
    @DisplayName("[Exception] 콤마로 구분된 문자가 숫자가 아니면 예외가 발생한다.")
    void notNumeric(String wrongInput) {
        Assertions.assertThatThrownBy(() -> WinningNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,45,15,43", "1,45,22,23,24,25", "39,38,23,24,25,11"})
    @DisplayName("[Success] 제한된 길이 이내이고, 양 끝에 콤마가 없고, 콤마로 구분된 문자가 숫자이고, 중복되지 않은 1 ~ 45 수이면 성공이다.")
    void validWinningNumber(String correctInput) {
        Assertions.assertThatCode(() -> WinningNumberInputValidator.validate(correctInput))
                .doesNotThrowAnyException();
    }
}