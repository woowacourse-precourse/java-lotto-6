package lotto.view;

import lotto.domain.Ranking;

import java.util.Map;

public class OutputView {
    public static int MONEYUNIT = 1000;
    public static int PERCENT = 100;
    public static void PrintStart () {
        System.out.println("당첨 통계\n---");
    }
    public static void printEnd(Map<Ranking, Integer> maching) {
        for (int i = 0; i < Ranking.values().length; i++ ){
            Ranking.values()[i].printMessage(maching.get(Ranking.values()[i]));
        }
    }
    public static void printRate(Map<Ranking, Integer> result, int lottoAmount) {
        double Revenue = 0;
        for (Ranking rank : result.keySet()) { //key값만 가져와서 순회
            Revenue = Revenue + ((double) (rank.getRevenue()) * (result.get(rank)) * (PERCENT) / (lottoAmount * MONEYUNIT));
        }
        System.out.println("총 수익률은 " + String.format("%.1f", Revenue).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "%입니다.");
    }
}
