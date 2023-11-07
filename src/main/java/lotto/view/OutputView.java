package lotto.view;

import java.util.List;
import lotto.model.LottoUtil;

public class OutputView {

    public static void printTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printSuccessMessage(List<Long> countList, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countList.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + countList.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countList.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countList.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countList.get(4) + "개");
        printRevenueRate(LottoUtil.calculateRate(
                countList.get(0) * 5000 + countList.get(1) * 50000 + countList.get(2) * 1500000
                        + countList.get(3) * 30000000
                        + countList.get(4) * 2000000000,
                amount));
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}