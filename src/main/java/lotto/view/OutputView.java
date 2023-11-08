package lotto.view;

import lotto.LottoResult;
import lotto.model.Lotto;
import lotto.model.ProfitStats;
import lotto.model.TotalResult;

import java.util.List;

import static lotto.Util.println;

public class OutputView {
    public static void printPurchaseAmount(int amount) {
        println(String.format("\n%d개를 구매했습니다.\n", amount));
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            println(lotto.getNumbers());
        }
    }

    public static void printTotalLottoResult(TotalResult totalResult) {
        printLottoResultHeader();
        for (int i = 4; i >= 0; i--) {
            LottoResult type = LottoResult.values()[i];
            String detail = type.getDetail();
            println(String.format("%s - %d개", detail, totalResult.get(type)));
        }
    }

    public static void printLottoResultHeader() {
        println("\n당첨 통계");
        println("---");
    }

    public static void printEarningRate(ProfitStats profitStats) {
        println(String.format("총 수익률은 %.1f%%입니다.", profitStats.getRate()));
    }
}
