package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult) {
        if (lottoResult != null) {
            String result = "당첨 통계\n"
                    + "---\n"
                    + "3개 일치 (5,000원) - " + lottoResult.getCount(Rank.FIFTH) + "개\n"
                    + "4개 일치 (50,000원) - " + lottoResult.getCount(Rank.FOURTH) + "개\n"
                    + "5개 일치 (1,500,000원) - " + lottoResult.getCount(Rank.THIRD) + "개\n"
                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getCount(Rank.SECOND) + "개\n"
                    + "6개 일치 (2,000,000,000원) - " + lottoResult.getCount(Rank.FIRST) + "개";
            printMessage(result);
        }
    }

    public static void printLottoNumbers(int numberOfPurchasedLottos, List<Lotto> lottos) {
        printMessage(numberOfPurchasedLottos + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        printEmptyLine();
    }

    public static void printWinningRate(double winningRate) {
        printMessage("총 수익률은 " + winningRate + "%입니다.");
    }
}
