package lotto.view.validator;

import lotto.utils.message.InputExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "    ", "     "})
    @DisplayName("[Exception] 공백 입력 시 예외가 발생한다.")
    void blank(String wrongInput) {
        Assertions.assertThatThrownBy(() -> BonusNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.BLANK.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 12", "4 5", "123", "1234", "  1"})
    @DisplayName("[Exception] 2글자 이상 입력 시 예외가 발생한다.")
    void exceedLength(String wrongInput) {
        Assertions.assertThatThrownBy(() -> BonusNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.EXCEED_BONUS_NUMBER_LENGTH.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"4r", "I1", "1 ", " 7", "7김"})
    @DisplayName("[Exception] 숫자가 아닌 입력 시 예외가 발생한다.")
    void notNumeric(String wrongInput) {
        Assertions.assertThatThrownBy(() -> BonusNumberInputValidator.validate(wrongInput))
                .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
    }

}