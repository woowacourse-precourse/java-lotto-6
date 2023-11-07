package lotto.view;

import lotto.model.Ranking;

import java.util.HashMap;
import java.util.List;

public class OutputMessage {

    public static void lottoNumber(List<Integer> number) {
        System.out.println(number);
    }

    public static void purchaseMessage(int output){
        System.out.printf("\n%d개를 구매했습니다.\n",output);
    }

    public static void winningMessage() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private static void showResult(HashMap<Ranking,Integer> map, Ranking ranking){
        if(ranking.getCount() == 0){
            return;
        }
        if(ranking.equals(Ranking.FIVE_BONUS)){
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",ranking.getCount(),ranking.getStringReward(),map.get(ranking));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", ranking.getCount(), ranking.getStringReward(), map.get(ranking));
    }

    public static void showRank(HashMap<Ranking,Integer> map){
        for(Ranking ranking : Ranking.values()){
            showResult(map,ranking);
        }
    }

    public static void showYieldResult(double yield){
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }

}
