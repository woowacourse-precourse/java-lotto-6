package lotto.util;

import lotto.exception.LottoGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class LottoGameExceptionTest {

    @ParameterizedTest
    @EnumSource(value = LottoGameException.class)
    public void ExceptionMessageTest(LottoGameException lottoGameException) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    throw lottoGameException.makeException();
                }).withMessage(lottoGameException.getExceptionMessage());
    }
}