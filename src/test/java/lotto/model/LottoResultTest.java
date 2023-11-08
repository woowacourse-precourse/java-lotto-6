package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import lotto.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void init() {
        List<Ranking> rankings = List.of(Ranking.FIRST, Ranking.NONE, Ranking.THIRD, Ranking.NONE, Ranking.FIFTH,
                Ranking.FIFTH);
        int investmentCost = rankings.size() * Constants.LOTTO_PRICE;

        lottoResult = new LottoResult(rankings, investmentCost);
    }

    @Test
    void 오등에_당첨된_티켓은_두개() {
        Ranking rankingForCount = Ranking.FIFTH;
        int expected = 2;

        int count = lottoResult.getCount(rankingForCount);

        assertEquals(expected, count);
    }

    @Test
    void testRoi() {
        BigDecimal expected = BigDecimal.valueOf(333585000, 1);

        BigDecimal roi = lottoResult.getRoi();

        assertEquals(expected, roi);
    }
}
