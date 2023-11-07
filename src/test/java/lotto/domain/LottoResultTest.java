package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    private LottoMoneyPrize lottoMoneyPrize = new LottoMoneyPrize();

    @Test
    @DisplayName("로또 결과 확인 테스트")
    void checkLottoResult(){
        //given
        List<Integer> userWin = Arrays.asList(1,2,3,4,5,6);
        List<Integer> randomWin = Arrays.asList(1,30,2,5,6,7);
        int bonusNum = 37;

        //when
        lottoMoneyPrize.printLottoPrize(userWin,randomWin,bonusNum);
        Map<LottoMoney, Integer> result = lottoMoneyPrize.getLottoMoneyPrize();
        int lottoPrizeCount = result.get(LottoMoney.FOURTH);
        int lottoPrizeCount2 = result.get(LottoMoney.SECOND);

        //then
        assertEquals(lottoPrizeCount,1);
        assertEquals(lottoPrizeCount2,0);
    }

}