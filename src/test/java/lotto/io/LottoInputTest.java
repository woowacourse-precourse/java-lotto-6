package lotto.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoInputTest {

    @Test
    void 구입_금액을_입력받는다() {
        LottoInput lottoInput = new LottoInput(() -> "1000");

        assertEquals(1000, lottoInput.receiveMoney());
    }

    @Test
    void 구입_금액이_숫자가_아닌경우_예외를_반환한다() {
        LottoInput lottoInput = new LottoInput(() -> "a");

        assertThatThrownBy(lottoInput::receiveMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IoException.ERROR.getMessage());
    }

}