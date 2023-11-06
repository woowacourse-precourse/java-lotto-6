package lotto;

import lotto.io.LottoPrizeResult;
import org.junit.jupiter.api.Test;

public class LottoPrizeResultTest {

    private LottoPrizeResult lpr;

    @Test
    public void messageTest(){
        System.out.println(LottoPrizeResult.FIVE_MATCH.getMessage());
        System.out.println(LottoPrizeResult.FIVE_MATCH);
        //5개 일치
        //FIVE_MATCH
        for(LottoPrizeResult result : LottoPrizeResult.values()){
            System.out.println(result.getMessage() + " (" + result.getMessage1() + ")");
        }
    }



}
