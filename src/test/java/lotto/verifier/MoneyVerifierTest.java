package lotto.verifier;

import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyVerifierTest {

    private final Verifier moneyVerifier = new MoneyVerifier();

    @Test
    void 로또구입금액이_숫자가_아닌경우() {
        assertThatThrownBy(() -> moneyVerifier.check("hello342"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
    }

    @Test
    void 로또구입금액이_Long범위를_벗어난_경우() {
        BigInteger longExceedingMax = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.TEN);
        assertThatThrownBy(() -> moneyVerifier.check(longExceedingMax.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.OUT_OF_RANGE);
    }

    @Test
    void 로또구입금액이_0보다_같거나작은경우() {
        assertThatThrownBy(() -> moneyVerifier.check("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_POSITIVE);
    }

    @Test
    void 로또구입금액이_1000원으로_나눠떨어지지_않는경우() {
        assertThatThrownBy(() -> moneyVerifier.check("15001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_DIVISIBLE);
    }

}