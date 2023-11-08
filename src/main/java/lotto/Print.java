package lotto;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public void printLottoCount(int purchaseCount){
        System.out.printf("%d개를 구매했습니다.%n", purchaseCount);
    }


    public void printLottos(List<List<Integer>> lottos) {
        List<Integer> lottoNumbers = null;
        List<Integer> eachLottoNumber = null;

        for (var lotto : lottos) {
//            eachLottoNumber = lotto.getLottoNumbers();
            System.out.println(lotto);
        }
    }


    public void printWinStatistic(){
        for (WinningRankPrize rankPlace : WinningRankPrize.values()){
            System.out.printf(rankPlace.getMatchCount() + " (%s원) - %d개%n", rankPlace.getPrizeAmount(), rankPlace.getWinCount());
        }
    }

}
