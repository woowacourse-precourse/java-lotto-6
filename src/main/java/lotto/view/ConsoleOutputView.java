package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    private static final int ONE_HUNDRED = 100;

    @Override
    public void printMoneyRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printPurchasedLottos(final List<List<Integer>> lottos) {
        printNewLine();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (final List<Integer> lotto : lottos) {
            List<Integer> purchasedLotto = new ArrayList<>(lotto);
            Collections.sort(purchasedLotto);
            System.out.println(purchasedLotto);
        }
    }

    @Override
    public void printWinningNumberRequestMessage() {
        printNewLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printBonusNumberRequestMessage() {
        printNewLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void printWinningStatistics(final int firstPrizeCount, final int secondPrizeCount, final int thirdPrizeCount,
                                       final int fourthPrizeCount, final int fifthPrizeCount) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthPrizeCount + "개");
        System.out.println("4개 일치 (50,000원) - "+ fourthPrizeCount + "개");
        System.out.println("5개 일치 (1,500,000원) - "+ thirdPrizeCount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ secondPrizeCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ firstPrizeCount + "개");
    }

    @Override
    public void printTotalProfit(final long totalPrize, final long money) {
        double totalProfit = ((double) totalPrize / money * ONE_HUNDRED);
        System.out.println("총 수익률은" + String.format("%.1f", totalProfit) + "%" + "입니다.");
    }

    @Override
    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }
}
