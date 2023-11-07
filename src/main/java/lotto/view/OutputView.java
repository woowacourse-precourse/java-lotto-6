package lotto.view;

import lotto.constant.Comments;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos){
        System.out.println();
        System.out.println(String.format(Comments.BUY_LOTTO_COUNT,lottos.size()));
        for(int i=0; i<lottos.size(); i++){
            printLotto(lottos.get(i));
        }
    }

    public static void printLotto(Lotto lotto){
        System.out.print("[");
        for(int i = 0; i< lotto.getLotto().size(); i++){
            System.out.print(lotto.getLotto().get(i));
            if(i != 5){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printResult(){
        System.out.println();
        System.out.println(Comments.LOTTERY_STATISTICS);
        System.out.println(Comments.SEPARATE_LINE);
    }

    public static void printEachMatchResult(List<Integer> ranking){
        int rankingIdx = 5;
        for(Rank rank : Rank.values()){
            if(rank != Rank.MATCH_5_BONUS) {
                System.out.println(String.format(Comments.MATCHED_NO_BONUS,rank.getMatchNumber(),String.format("%,d", rank.getprizeMoney()), ranking.get(rankingIdx)));
                rankingIdx--;
                continue;
            }
            System.out.println(String.format(Comments.MATCHED_WITH_BONUS,rank.getMatchNumber(),String.format("%,d", rank.getprizeMoney()), ranking.get(rankingIdx)));
            rankingIdx--;
        }
    }

    public static void printReturnRate(String returnRate){
        System.out.println(String.format(Comments.RETURN_RATE, returnRate));
    }


}
