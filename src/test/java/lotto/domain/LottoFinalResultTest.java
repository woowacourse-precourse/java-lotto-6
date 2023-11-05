package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoFinalResultTest {
    @Test
    void Lotto_Final_Result_생성() {
        LottoFinalResult lottoFinalResult = new LottoFinalResult();
        lottoFinalResult.addLottoResult(LottoResult.FIVE);

        Integer lottoResultCount = lottoFinalResult.getFinalResultMap().get(LottoResult.FIVE);
        assertThat(lottoResultCount).isEqualTo(1);
    }
}
