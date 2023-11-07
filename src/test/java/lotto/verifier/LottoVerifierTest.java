package lotto.verifier;

import lotto.system.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVerifierTest {

    private final Verifier lottoVerifier = new LottoVerifier();


    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "1",
            "1,2",
            "1,2,3",
            "1,2,3,4"
            ,"1,2,3,4,5",
            "1,2,3,4,5,6,7"
    })
    void 로또_번호의_갯수가_6개가_아닌경우(String input) {
        assertThatThrownBy(() -> lottoVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.COUNT_NOT_EQUAL);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,a,3,4,k,9",
            "1,2,a,@,4,5",
            "4,5,7,24,9@,7 "
    })
    void 로또_번호가_숫자가_아닌경우(String input) {
        assertThatThrownBy(() -> lottoVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-9223372036854775809,1,2,3,4,5",
            "1,2,3,4,5,9223372036854775808"
    })
    void 로또_번호가_Long타입으로_변환될수_없는경우(String input) {
        assertThatThrownBy(() -> lottoVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,47,4,5",
            "17,148,13,-2,5,9",
            "24,38,54,14,21,7"
    })
    void 로또_번호가_1부터45사이의_숫자가_아닌경우(String input) {
        assertThatThrownBy(() -> lottoVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,1,5,8,9,21",
            "2,6,4,8,9,2",
            "17,25,28,31,26,31"
    })
    void 로또_번호가_중복되는_경우(String input) {
        assertThatThrownBy(() -> lottoVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_NOT_DISTINCT);
    }

}