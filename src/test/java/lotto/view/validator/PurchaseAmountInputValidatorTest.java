package lotto.view.validator;

import lotto.utils.message.InputExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "      ", "\n", "\r", "\t"})
    @DisplayName("[Exception] 공백만 입력")
    void onlyBlank(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountInputValidator.validate(input))
                .hasMessage(InputExceptionMessage.BLANK.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000000000", "2147483647"})
    @DisplayName("[Exception] 최대 9자리 초과 입력")
    void exceedLength(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountInputValidator.validate(input))
                .hasMessage(InputExceptionMessage.EXCEED_PURCHASE_AMOUNT_LENGTH.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1000", "1000 ", " 1000 ", " 1000   ", "  1000   ", "    1000 "})
    @DisplayName("[Exception] 숫자와 공백 혼합 입력")
    void numericWithBlank(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountInputValidator.validate(input))
                .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"r1000", "m1000", "zzz", "!_!", "dfdf", "Iooo"})
    @DisplayName("[Exception] 문자 입력")
    void notNumeric(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountInputValidator.validate(input))
                .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "100000000", "11000", "220000", "3345000", "98765000", "10101000"})
    @DisplayName("[Success] 제한 길이 이내이고, 숫자로만 이루어져있고, 1000원 단위인 입력")
    void validAmount(String input) {
        Assertions.assertThatCode(() -> PurchaseAmountInputValidator.validate(input))
                .doesNotThrowAnyException();
    }
}