package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinalResultTest {

    @Test
    @DisplayName("FinalResult 객체 생성")
    void lottoResult() {
        // given
        LottoResult lottoResult = new LottoResult(new LottoMatchCount(1, 2, 3, 4, 5));
        // when
        FinalResult finalResult = new FinalResult(lottoResult);
        // then
        assertNotNull(finalResult);
    }
}