package view;

import domain.Lotto;
import domain.Rank;

import java.util.Map;


public class OutputView {
    public static void printPurchaseAmount(int lottoAmount){
        System.out.println("\n"+lottoAmount+"개를 구매했습니다.");
    }
    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }
    public static void printStatisticsResult(Map<Rank,Integer> result) {
        System.out.println("당첨 통계\n---");
        for (int i = 1; i < Rank.values().length; i++) {
            System.out.println(Rank.values()[i].getMessage() + result.get(Rank.values()[i])+"개");
        }
    }
}
