package view;

import domain.Lotto;
import domain.Rank;

import java.util.Map;


public class OutputView {
    public static void printPurchaseAmount(int lottoAmount){
        System.out.println("\n"+lottoAmount+"개를 구매했습니다.");
    }
    public static void printLotto(Lotto lotto) {
        System.out.print(lotto.getNumbers().toString()+"\n");
    }
    public static void printStatisticsResult(Map<Rank,Integer> result) {
        System.out.println("\n당첨 통계\n---");
        for (int i = 1; i < Rank.values().length; i++) {
            System.out.println(Rank.values()[i].getMessage() + result.get(Rank.values()[i])+"개");
        }
    }
    public static void printRateOfReturn(float rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.",rateOfReturn);
    }

}
