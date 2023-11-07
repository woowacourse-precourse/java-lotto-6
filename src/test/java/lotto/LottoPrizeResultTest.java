package lotto;

import lotto.io.LottoPrizeResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoPrizeResultTest {

    @Test
    public void getResultMessageTest(){
        int matchPoint = 5;
        boolean isBonus = false;
        int prizeMoney = 1_500_000;
        LottoPrizeResult fiveMatch = LottoPrizeResult.FIVE_MATCH;

        String prizeResultMessage = fiveMatch.getPrizeResultMessage(1);

        String prizeMoneyMessage = "5개 일치 ( 1,500,000원 ) - 1개";
        Assertions.assertEquals(prizeResultMessage,prizeMoneyMessage);
        System.out.println(prizeResultMessage);
        System.out.println(prizeMoneyMessage);
    }

    @Test
    public void getPrizeResultTest(){
        Assertions.assertEquals
          (LottoPrizeResult.FIVE_MATCH,
            LottoPrizeResult.getPrizeResult(5,false));
        Assertions.assertEquals
          (LottoPrizeResult.FIVE_MATCH_WITH_BONUS,
            LottoPrizeResult.getPrizeResult(5,true));
        Assertions.assertNull
          (LottoPrizeResult.getPrizeResult(1,false));

    }
}
