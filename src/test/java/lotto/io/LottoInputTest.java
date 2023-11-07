package lotto.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoInputTest {

    @Test
    void 구입_금액을_입력받는다() {
        LottoInput lottoInput = new LottoInput(() -> "1000");

        assertEquals(1000, lottoInput.receiveMoney());
    }

}