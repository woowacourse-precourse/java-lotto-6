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

    public void printLottoResult(UserLotto userLotto, Map<WinningResult, Integer> countOfWinningResult) {
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
            System.out.println(" " + "(" + decimalFormat.format(winningResult.getPrice()) + ")" + " - " + countOfWinningResult.getOrDefault(winningResult, 0) + "개");
        }
        System.out.println("총 수익률은 " + calculateRateOfReturn(userLotto) + "%입니다.");
    }

    private double calculateRateOfReturn(UserLotto userLotto) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format((double) userLotto.getWinningPrice() / userLotto.getPurchasePrice() * 100));
    }

}
