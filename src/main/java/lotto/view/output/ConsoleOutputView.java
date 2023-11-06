package lotto.view.output;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printNewLine() {
        System.out.println();
    }

    @Override
    public void printLottoQuantity(int purchaseResult) {
        printNewLine();
        System.out.println(purchaseResult + "개를 구매했습니다.");
    }

    @Override
    public void printPurchasedLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    @Override
    public void printGameResults(List<Integer> gameResults) {
        System.out.println("3개 일치 (5,000원) - " + gameResults.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + gameResults.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + gameResults.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + gameResults.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " +  + gameResults.get(0) + "개");
    }

    @Override
    public void printGameProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
