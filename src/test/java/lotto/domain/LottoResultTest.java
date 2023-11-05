package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void getResult() {
        assertEquals(LottoResult.FIRST, LottoResult.getResult(6, false));
        assertEquals(LottoResult.SECOND, LottoResult.getResult(5, true));
        assertEquals(LottoResult.THIRD, LottoResult.getResult(5, false));
    }
}