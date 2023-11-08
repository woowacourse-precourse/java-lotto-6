package lotto;

import java.util.ArrayList;
import java.util.List;

public class Print {

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
