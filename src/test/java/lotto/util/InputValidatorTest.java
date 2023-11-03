package lotto.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    public static InputValidator inputValidator;
    @BeforeAll
    public static void initializer(){
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "12", "43"})
    @DisplayName("사용자_입력_숫자형_통과_테스트")
    void valid_isNumericValidator(String input) {
        // given
        Boolean isValid;
        // when
        isValid = inputValidator.isNumericValidator(input);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"만오천", "14000원", "  12000"})
    @DisplayName("사용자_입력_숫자형_불통과_테스트")
    void invalid_isNumericValidator(String input) {
        // given
        // when & then
        assertThatThrownBy(()->inputValidator.isNumericValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력은 숫자 형태여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 20000, 600})
    @DisplayName("사용자_입력_숫자형_불통과_테스트")
    void valid_isThousandUnitValidator() {
        // given
        // when
        // then
    }

    @Test
    void isInRangeValidator() {
    }

    @Test
    void isNotOverlapSixValidator() {
    }

    @Test
    void isNotOverlapBonusValidator() {
    }
}