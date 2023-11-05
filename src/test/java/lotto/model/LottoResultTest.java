package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private static LottoResult lottoResult;

    @BeforeAll
    private static void beforeAll() {
        lottoResult = new LottoResult();
        lottoResult.addOne(Rank.FIRST);
        lottoResult.addOne(Rank.THIRD);
        lottoResult.addOne(Rank.THIRD);
        lottoResult.addOne(Rank.FIFTH);
        lottoResult.addOne(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또 당첨내역 확인")
    void printResults() {
        System.out.println(lottoResult.buildResultString());
    }
}