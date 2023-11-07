package lotto.manager;

import java.util.List;
import java.util.Map;

public class OutputManager {
    public void printInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicketCount(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void printRandomNumber(List<List<Integer>> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            System.out.println(randomNumbers.get(i));
        }
    }

    public void printWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningMessage(Map<Integer, Integer> matchedNumberCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchedNumberCount.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchedNumberCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchedNumberCount.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchedNumberCount.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchedNumberCount.get(6) + "개");
    }

    public void printProfitRate(double profitRate) {
        String formatProfitRate = String.format("%.1f%%", profitRate);
        System.out.println("총 수익률은 " + formatProfitRate + "입니다.");
    }
}
