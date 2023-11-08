package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("LottoResult의 LottoMatchCount의 countOf3의 수를 확인한다.")
    void lottoMatchCount() {
        // given
        LottoMatchCount lottoMatchCount = new LottoMatchCount(3, 0,0,0,0);
        LottoResult lottoResult = new LottoResult(lottoMatchCount);

        // when
        Integer matchCount = lottoResult.lottoMatchCount().countOf3();

        // then
        assertEquals(3, matchCount);
    }
}