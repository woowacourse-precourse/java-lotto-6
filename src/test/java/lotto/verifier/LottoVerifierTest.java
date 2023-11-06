package lotto.verifier;

import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVerifierTest {

    private final Verifier lottoVerifier = new LottoVerifier();


    @Test
    void 로또_번호의_갯수가_6개가_아닌경우() {
        assertThatThrownBy(() -> lottoVerifier.check("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.COUNT_NOT_EQUAL);
    }

    @Test
    void 로또_번호가_숫자가_아닌경우() {
        assertThatThrownBy(() -> lottoVerifier.check("1,k,d,2,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
    }

    @Test
    void 로또_번호가_Long타입으로_변환될수_없는경우() {
        BigInteger longExceedingMax = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.TEN);
        assertThatThrownBy(() -> lottoVerifier.check("1,2,3,4,5," + longExceedingMax))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
    }

    @Test
    void 로또_번호가_1부터45사이의_숫자가_아닌경우() {
        assertThatThrownBy(() -> lottoVerifier.check("1,2,3,47,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
    }

    @Test
    void 로또_번호가_중복되는_경우() {
        assertThatThrownBy(() -> lottoVerifier.check("1,2,3,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_NOT_DISTINCT);
    }

}