package lotto.util;

import lotto.exception.LottoGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class LottoGameExceptionTest {

    @ParameterizedTest
    @EnumSource(value = LottoGameException.class)
    public void Exception이_정상적으로_반환된다(LottoGameException lottoGameException) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    throw lottoGameException.makeException();
                }).withMessage(lottoGameException.getExceptionMessage());
    }
}