package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorTest {

    private Validator validator;

    public ValidatorTest() {
        validator = new Validator();
        validator.setMaxMoney(1000000);
    }

    @ParameterizedTest
    @MethodSource("lotto.validator.ArgumentsProvider#provideCorrectInput")
    @DisplayName("구입 구매 검증")
    void 구입_금액_검증(String input) {
        validator.validateMoney(input);
    }

    @ParameterizedTest
    @MethodSource("lotto.validator.ArgumentsProvider#provideExceptionInput")
    @DisplayName("구입 구매 검증 예외")
    void 구입_금액_검증_예외(String input) {
        Assertions.assertThatThrownBy(() -> validator.validateMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}