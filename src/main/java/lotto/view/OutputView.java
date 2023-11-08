package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.WinningStatistics;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }

    public static void printLottos(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public static void printResult(WinningStatistics winningStatistics) {
        int three = winningStatistics.getThree();
        int four = winningStatistics.getFour();
        int five = winningStatistics.getFive();
        int fiveWithBonus = winningStatistics.getFiveWithBonus();
        int six = winningStatistics.getSix();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
    }

    public static void printPurchaseCount(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }
}