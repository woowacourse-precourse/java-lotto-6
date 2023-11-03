package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("당첨 개수가 3인것은 enum에 존재하므로 lottoResult값을 반환한다.")
    void countThree() throws Exception {
        LottoResult lottoResult = LottoResult.findByCountAndValidBonus(3, false);
        assertNotNull(lottoResult);
    }

    @Test
    @DisplayName("당첨 개수가 2인것은 enum에 존재하므로 lottoResult값을 반환한다.")
    void countTwo() throws Exception {
        LottoResult lottoResult = LottoResult.findByCountAndValidBonus(2, false);
        assertNull(lottoResult);
    }

    @Test
    @DisplayName("당첨 개수가 5일때 보너스 당첨 여부에 따라 반환되는 lottoResult값이 달라진다")
    void compareCountFive() throws Exception {
        LottoResult lottoResultTrue = LottoResult.findByCountAndValidBonus(5, true);
        LottoResult lottoResultFalse = LottoResult.findByCountAndValidBonus(5, false);

        assertNotSame(lottoResultTrue, lottoResultFalse);
    }

}