package view;

import java.util.HashMap;
import java.util.List;
import model.Lotto;

public class OutputView {

    public static void showGeneratedLotto(int lottoMount, List<Lotto> generatedLottos) {
        System.out.println(lottoMount + "개를 구매했습니다.");

        for (Lotto ticket : generatedLottos) {
            System.out.println(ticket.getNumbers());
        }
        System.out.println();
    }

    public static void showFinalResult(HashMap<String, Integer> winningResults, String winningRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResults.get(WinningPrize.FIFTH.getMatchCount()) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResults.get(WinningPrize.FOURTH.getMatchCount()) + "개");
        System.out.println("5개 일치 (5,000원) -" + winningResults.get(WinningPrize.THIRD.getMatchCount()) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResults.get(WinningPrize.SECOND.getMatchCount()) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResults.get(WinningPrize.FIRST.getMatchCount()) + "개");
        System.out.println("수익률은 " + winningRate + "%입니다.");
    }
}
