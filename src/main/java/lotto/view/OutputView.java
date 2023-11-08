package lotto.view;


import java.util.List;
import lotto.constants.Config;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.utils.Formatter;

public class OutputView {
    public void printGeneratedLottos(LottoMachine lottoMachine) {
        long lottoCount = lottoMachine.getInputAmount() / Config.LOTTO_PRICE;
        System.out.println(lottoCount+"개를 구매했습니다.");
        List<Lotto> lottos = lottoMachine.getLottos();
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public void printLottoResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankStatistics("3개 일치", Rank.FIFTH, result);
        printRankStatistics("4개 일치", Rank.FOURTH, result);
        printRankStatistics( "5개 일치", Rank.THIRD, result);
        printRankStatistics("5개 일치, 보너스 볼 일치",Rank.SECOND, result);
        printRankStatistics("6개 일치",Rank.FIRST, result);
        System.out.println("총 수익률은 " + result.getProfitRate() + "%입니다.");
    }

    private void printRankStatistics(String description, Rank rank, Result result) {
        int count = result.getCountOfMatch(rank);
        String formattedMoney = Formatter.moneyFormat(rank.getWinningMoney());
        System.out.println(description + " (" + formattedMoney + "원) - " + count + "개");
    }
}
