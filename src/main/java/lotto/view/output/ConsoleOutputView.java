package lotto.view.output;

import lotto.domain.Game;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printCostMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

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
        lotto.sort(Integer::compareTo);
        System.out.println(lotto);
    }

    @Override
    public void printWinnerNumberMessage() {
        printNewLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printBonusNumberMessage() {
        printNewLine();
        System.out.println("보너스 번호를 입력해 주세요.");
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
