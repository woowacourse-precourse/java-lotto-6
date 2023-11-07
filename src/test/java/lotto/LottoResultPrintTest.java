package lotto;

import lotto.io.LottoPrizeResult;
import lotto.view.LottoResultPrint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultPrintTest {

    private LottoResultPrint lottoResultPrint;

    @BeforeEach
    public void setUp(){
        lottoResultPrint = new LottoResultPrint();
    }

    @Test
    public void addResultTest(){
        int matchPoint = 3;
        boolean isBonus = false;

        lottoResultPrint.addResult(matchPoint,isBonus);
        lottoResultPrint.addResult(matchPoint,isBonus);
        Assertions.assertEquals(2,lottoResultPrint.getResultMap().get(LottoPrizeResult.THREE_MATCH));
    }



}
