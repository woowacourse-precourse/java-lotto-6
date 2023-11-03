package lotto.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    public static InputValidator inputValidator;
    @BeforeAll
    public static void initializer(){
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "12", "43"})
    void valid_isNumericValidator(String input) {
        // given
        // when

        // then

    }

    @Test
    void isThousandUnitValidator() {
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