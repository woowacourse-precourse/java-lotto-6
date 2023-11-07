package lotto.verifier;

import lotto.system.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyVerifierTest {

    private final Verifier moneyVerifier = new MoneyVerifier();

    @ParameterizedTest
    @ValueSource(strings = {
            "1234k",
            "@.381",
            "159a"
    })
    void 로또구입금액이_숫자가_아닌경우(String input) {
        assertThatThrownBy(() -> moneyVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-9223372036854775809",
            "22337203685477580883"
    })
    void 로또구입금액이_Long범위를_벗어난_경우(String input) {
        assertThatThrownBy(() -> moneyVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.OUT_OF_RANGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "0",
            "-1000",
            "-2000"
    })
    void 로또구입금액이_0보다_같거나작은경우(String input) {
        assertThatThrownBy(() -> moneyVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_POSITIVE);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "10001",
            "20083",
            "30072"
    })
    void 로또구입금액이_1000원으로_나눠떨어지지_않는경우(String input) {
        assertThatThrownBy(() -> moneyVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_DIVISIBLE);
    }

}