package lotto.validator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoValidatorTest {
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"0",
            "2450",
            "3500"})
    void 로또_구매할_금액_테스트(String amount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.amountInputValidator(amount)
        );
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"sf",
            "rpr2",
            "4000z"})
    void 로또_구매할_금액_숫자_테스트(String amount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.amountInputValidator(amount)
        );
    }
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"",
            "",
            "       "})
    void 로또_구매할_금액_공백_테스트(String amount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoValidator.amountInputValidator(amount)
        );
    }
}
