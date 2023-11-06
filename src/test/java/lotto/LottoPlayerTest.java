package lotto;

import lotto.Model.LottoPlayer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPlayerTest {



    @ParameterizedTest
    @ValueSource(ints = {0,-1, -100, -9802})
    public void 금액이_0원_이하인_경우_예외처리(Integer cache) {
        Assertions.assertThatThrownBy(() -> new LottoPlayer(cache))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 금액은 0원을 초과해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {3245, 100, 98200,37002})
    void 금액이_천원단위가_아닌_경우_예외처리(Integer cache) {
        Assertions.assertThatThrownBy(() -> new LottoPlayer(cache))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
