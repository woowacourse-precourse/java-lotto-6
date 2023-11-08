package lotto.domain;

import lotto.domain.lotto.enums.LottoRank;
import lotto.domain.result.LottoResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoResultTest {
    @Test
    @DisplayName("LottoRanks 를 통해 LottoResult 를 만든다.")
    void createLottoResultWithLottoPaperAndLottoDraw() {
        List<LottoRank> lottoRanks = List.of(LottoRank.FIRST, LottoRank.FIFTH);
        LottoResult lottoResult = LottoResult.of(lottoRanks);
        Assertions.assertEquals(lottoResult.getClass(), LottoResult.class);
        Assertions.assertEquals(lottoResult.lottoResultBoard().get(LottoRank.FIRST), 1);
        Assertions.assertEquals(lottoResult.lottoResultBoard().get(LottoRank.FIFTH), 1);
    }
}

