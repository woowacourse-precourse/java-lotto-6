package lotto.validation;

import lotto.system.ErrorMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusValidationTest {
    private final BonusValidation bonusValidation = new BonusValidation();

    @Nested
    @DisplayName("CheckOutOfRange 검증 테스트")
    class CheckOutOfRange {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {"-1", "100", "46", "47"})
        void 범위내_입력되지_않은_값을_테스트(String target) {
            assertThatThrownBy(() -> bonusValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    @Nested
    @DisplayName("check 검증 테스트")
    class CheckNumeric {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {" ", "jj","    "})
        void 범위내_입력되지_않은_값을_테스트(String target) {
            assertThatThrownBy(() -> bonusValidation.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NOT_NUMERIC);
        }
    }
}

