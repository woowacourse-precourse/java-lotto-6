package lotto.view;

import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.WinningResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottoQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }

    public void printLottoResult(Map<WinningResult, Integer> countOfWinningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        for (WinningResult winningResult : countOfWinningResult.keySet()) {
            if (winningResult == WinningResult.SECOND) {
                System.out.print("5개 일치, 보너스 볼 일치");
            }
            if (winningResult != WinningResult.SECOND) {
                System.out.print(winningResult.getValue() + "개 일치");
            }
            System.out.println(" " + "(" + decimalFormat.format(winningResult.getPrice()) + "원)" + " - " + countOfWinningResult.getOrDefault(winningResult, 0) + "개");
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
