package lotto.view.output;

import lotto.model.Game;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printNewLine() {
        System.out.println();
    }

    @Override
    public void printPurchaseResult(int purchaseResult) {
        printNewLine();
        System.out.println(purchaseResult + "개를 구매했습니다.");
    }

    @Override
    public void printLotto(List<Integer> lotto) {
        lotto = lotto.stream().sorted().toList();
        System.out.println(lotto);
    }

    @Override
    public void printGameResult(Game game) {
        System.out.println("3개 일치 (5,000원) - " + game.getResults().get(4).getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + game.getResults().get(3).getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + game.getResults().get(2).getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + game.getResults().get(1).getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " +  + game.getResults().get(0).getCount() + "개");
    }

    @Override
    public void printGameInterestRate(double interestRate) {
        System.out.println("총 수익률은 " + interestRate + "%입니다.");
    }
}
