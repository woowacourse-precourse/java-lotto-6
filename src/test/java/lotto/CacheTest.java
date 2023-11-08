package lotto;

import lotto.Controller.ErrorMessage;
import lotto.Model.Cache;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CacheTest {


    @ParameterizedTest
    @ValueSource(ints = {-1, -9, -999})
    public void 돈이_음수인_경우에_대한_예외처리(Integer number) {
        Assertions.assertThatThrownBy(() -> new Cache(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CASH_NEGATIVE.getMessage());
    }
}
