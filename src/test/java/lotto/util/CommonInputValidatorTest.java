package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

class CommonInputValidatorTest {
    private static final String IS_NUMERIC_VALIDATOR_ERROR_MESSAGE = "[ERROR] 입력은 숫자 형태여야 합니다.";
    private static final String IS_IN_RANGE_VALIDATOR_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    @ParameterizedTest
    @ValueSource(strings = {"만오천", "14000원", "  12000"})
    @DisplayName("사용자_입력_숫자형_불통과_테스트")
    void invalid_isNumericValidator(String input) {
        // given
        // when & then
        assertThatThrownBy(()-> CommonInputValidator.isNumericValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_NUMERIC_VALIDATOR_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    @DisplayName("당첨번호_입력_유효하지_못한_범위_테스트")
    void invalid_isInRangeValidator(Integer number) {
        // given
        // when & then
        assertThatThrownBy(()-> CommonInputValidator.isInRangeValidator(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_IN_RANGE_VALIDATOR_ERROR_MESSAGE);
    }
}