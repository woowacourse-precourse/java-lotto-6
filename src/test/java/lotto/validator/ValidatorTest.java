package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @MethodSource("lotto.validator.MoneyArgumentsProvider#provideCorrectInput")
    @DisplayName("구입 금액 검증")
    void 구입_금액_검증(String input) {
        validator.validateMoney(input);
    }

    @ParameterizedTest
    @MethodSource("lotto.validator.MoneyArgumentsProvider#provideExceptionInput")
    @DisplayName("구입 금액 검증 예외")
    void 구입_금액_검증_예외(String input) {
        assertThatThrownBy(() -> validator.validateMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lotto.validator.LottoNumberArgumentProvider#provideCorrectInput")
    @DisplayName("로또 번호 검증")
    void 로또_번호_검증(String input) {
        validator.validateLottoNumber(input);
    }

    @ParameterizedTest
    @MethodSource("lotto.validator.LottoNumberArgumentProvider#provideExceptionInput")
    @DisplayName("구입 금액 검증 예외")
    void 로또_번호_검증_예외(String input) {
        assertThatThrownBy(() -> validator.validateLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}