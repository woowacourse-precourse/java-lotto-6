package lotto;

import java.util.List;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult) {
        if (lottoResult != null) {
            StringBuilder result = new StringBuilder();
            result.append("당첨 통계\n");
            result.append("---\n");
            result.append("3개 일치 (5,000원) - ").append(lottoResult.getCount(Rank.FIFTH)).append("개\n");
            result.append("4개 일치 (50,000원) - ").append(lottoResult.getCount(Rank.FOURTH)).append("개\n");
            result.append("5개 일치 (1,500,000원) - ").append(lottoResult.getCount(Rank.THIRD)).append("개\n");
            result.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(lottoResult.getCount(Rank.SECOND)).append("개\n");
            result.append("6개 일치 (2,000,000,000원) - ").append(lottoResult.getCount(Rank.FIRST)).append("개");
            printMessage(result.toString());
        }
    }


    public static void printLottoNumbers(int numberOfPurchasedLottos, List<Lotto> lottos) {
        printMessage(numberOfPurchasedLottos + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningRate(double winningRate) {
        printMessage("총 수익률은 " + winningRate + "%입니다.");
    }
}
