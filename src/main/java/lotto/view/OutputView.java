package lotto.view;

import lotto.model.Lottos;
import lotto.Result;

public class OutputView {
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String MATCH_THREE = "3개 일치 (5,000원) - ";
    private static final String MATCH_FOUR = "4개 일치 (50,000원) - ";
    private static final String MATCH_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String MATCH_FIVE_AND_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String MATCH_SIX = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT = "개";
    private static final String PROFIT = "총 수익률은 ";
    private static final String PERCENT = "%입니다.";


    public void showPurchase(Lottos lottos){
        System.out.println(lottos.getCount()+PURCHASE_COUNT);
        System.out.println(lottos);
    }
    public void showResult(){
        System.out.println(MATCH_THREE+ Result.MATCH_THREE.getCount()+COUNT);
        System.out.println(MATCH_FOUR+Result.MATCH_FOUR.getCount()+COUNT);
        System.out.println(MATCH_FIVE+Result.MATCH_FIVE.getCount()+COUNT);
        System.out.println(MATCH_FIVE_AND_BONUS+Result.MATCH_FIVE_AND_BONUS.getCount()+COUNT);
        System.out.println(MATCH_SIX+Result.MATCH_SIX.getCount()+COUNT);
    }
    public void showProfit(double profit){
        System.out.println(PROFIT+profit+PERCENT);
    }
}
