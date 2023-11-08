package lotto;

import java.util.List;
import java.util.Map;
import lotto.Game.LottoRank;

public class OutputUser {
    public void outputBuyLotto(Integer totalLottoCount){
        System.out.printf("%d개를 구매했습니다.\n", totalLottoCount);
    }
    public void outputBuyLottoNumbers(List<Lotto> numberTickets){
        for (Lotto lotto : numberTickets){
            System.out.println(lotto.getNumbers());
        }
    }
    public void outputLottoGameResult(Map<LottoRank, Integer> lottoGameResult, double profitRate){
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()){
            if (rank.equals(LottoRank.NONE)){
                continue;
            }
            System.out.printf("%s - %d개\n", rank.getMaseege(),lottoGameResult.get(rank));
        }
        System.out.printf("총 수익률은 %.2f%%입니다.\n", profitRate);
    }
}
