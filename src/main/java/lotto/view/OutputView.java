package lotto.view;

import java.util.List;

public class OutputView {
    public void showPurchaseMessage(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void showLottoTickets(List<List<Integer> > tickets) {
        System.out.println("구매한 로또 번호:");
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void showWinningStatistics(List<Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(4) + "개");
    }

    public void showTotalIncomeRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
