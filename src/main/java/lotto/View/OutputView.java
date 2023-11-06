package lotto.View;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;

import static lotto.domain.LottoRank.*;

public class OutputView {


    public static void printBuyLottoCount(int count){
        System.out.println("\n"+count+"개를 구매했습니다.");
    }
    public static void PrintUserLottoTickets(List<Lotto> lottoList) {
        lottoList.forEach(i -> System.out.println(i.getSortLottoNumber()));
    }

    public static void printUserPrizeStats(LottoResult lottoResult) {
        System.out.println("\n"+"당첨 통계");
        System.out.println("---");
        System.out.println(FIFTH.getMessage() + lottoResult.getLottoCountByRank(FIFTH) + "개");
        System.out.println(FOURTH.getMessage() + lottoResult.getLottoCountByRank(FOURTH) + "개");
        System.out.println(THIRD.getMessage() + lottoResult.getLottoCountByRank(THIRD) + "개");
        System.out.println(SECOND.getMessage() + lottoResult.getLottoCountByRank(SECOND) + "개");
        System.out.println(FIRST.getMessage() + lottoResult.getLottoCountByRank(FIRST) + "개");
    }

    public static void PrintUserProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

}
