package lotto.View;

import lotto.Model.Lotto;

import java.util.List;
import java.util.Map;

public class LottoGameView {
    public void displayNumberOfTickets(int numTickets) {
        System.out.println(numTickets + "개를 구매했습니다.");
    }

    public void displayTickets(List<Lotto> tickets) {
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayResults(Map<Integer, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i <= 5; i++) {
            int prizeMoney = getPrizeMoney(i);
            int count = results.getOrDefault(i, 0);
            System.out.println(i + "개 일치 (" + prizeMoney + "원) - " + count + "개");
        }
        int count = results.getOrDefault(7, 0);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        count = results.getOrDefault(6, 0);
        System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
    }
    public void displayTotalRevenueRate(double revenueRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenueRate) + "%입니다.");
    }

    private int getPrizeMoney(int matchingNumbers) {
        if (matchingNumbers == 3) {
            return 5000;
        }
        if (matchingNumbers == 4) {
            return 50000;
        }
        if (matchingNumbers == 5) {
            return 1500000;
        }

        return 0;
    }



}
