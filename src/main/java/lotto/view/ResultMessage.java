package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class ResultMessage {

    private static final int RATE_PERCENT = 100;
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_TOP_MESSAGE = "당첨 통계";

    public static void setPurchaseMessage(Amount amount, List<Lotto> lotto){
        System.out.println();
        System.out.println(amount.getCount() + PURCHASE_MESSAGE);
        printPurchaseLottoNum(amount.getCount(),lotto);
    }

    private static void printPurchaseLottoNum(int purchaseAmount, List<Lotto> lotto) {
        for (int count = 0; count < purchaseAmount; count++) {
            System.out.println(lotto.get(count).getNumbers());
        }

        System.out.println();
    }

    public static void printResult(Map<Rank,Integer> result, Amount amount){
        System.out.println();
        System.out.println(RESULT_TOP_MESSAGE);
        System.out.println("---");

        printDrawResult(result);
        printReturnRate(result, amount);
    }

    private static void printDrawResult(Map<Rank,Integer> result){
        for (int count = 0; count < Rank.values().length - 1; count++) {
            System.out.print(Rank.values()[count].getWinningMesaage());
            System.out.println(result.get(Rank.values()[count])+"개");
        }
    }

    private static void printReturnRate(Map<Rank,Integer> result, Amount amount){
        double ReturnRate = 0;
        for(Rank rank : result.keySet()){
            ReturnRate += rank.getPrizeAmount() * result.get(rank);
        }

        ReturnRate=(ReturnRate/amount.getTotal())*RATE_PERCENT;

        System.out.println("총 수익률은 "+ReturnRate+"%입니다.");
    }
}
