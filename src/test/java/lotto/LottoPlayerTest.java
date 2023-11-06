package lotto;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.Model.LottoPlayer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPlayerTest {

    @ParameterizedTest
    @ValueSource(ints = {3245, 100, 98200,37002})
    void 금액이_천원단위가_아닌_경우_예외처리(Integer cache) {
        Assertions.assertThatThrownBy(() -> new LottoPlayer(cache))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
