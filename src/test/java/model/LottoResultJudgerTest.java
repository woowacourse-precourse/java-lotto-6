package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import model.enums.LottoWinResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultJudgerTest {
    private static LottoResultJudger lottoResultJudger;
    private static Map<String, Integer> winResults;
    private static int paidMoney;

    @DisplayName("주어진 win 목록과 투자금을 통해 도출한 수익률 값 테스트 - LOTTO_3SAME 1개")
    @Test
    void lottoResultJudgeTest1() {
        paidMoney = 8000;

        winResults = new HashMap<>();
        winResults.put(LottoWinResults.LOTTO_3SAME.getMessage() ,1);
        winResults.put(LottoWinResults.LOTTO_4SAME.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_5SAME.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_5SAME_BONUS.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_6SAME.getMessage() ,0);

        lottoResultJudger = new LottoResultJudger(winResults,paidMoney);
        System.out.println(lottoResultJudger.getProfit());
        assertThat(lottoResultJudger.getProfit()).isEqualTo(62.5);
    }

    @DisplayName("주어진 win 목록과 투자금을 통해 도출한 수익률 값 테스트- LOTTO_6SAME 1개")
    @Test
    void lottoResultJudgeTest2() {
        paidMoney = 8000;

        winResults = new HashMap<>();
        winResults.put(LottoWinResults.LOTTO_3SAME.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_4SAME.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_5SAME.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_5SAME_BONUS.getMessage() ,0);
        winResults.put(LottoWinResults.LOTTO_6SAME.getMessage() ,1);
        lottoResultJudger = new LottoResultJudger(winResults,paidMoney);
        assertThat(lottoResultJudger.getProfit()).isEqualTo(25000000.0);
    }

}
