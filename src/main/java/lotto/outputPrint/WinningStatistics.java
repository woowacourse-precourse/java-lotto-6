package lotto.outputPrint;

import java.util.Map;
import java.util.Map.Entry;
import lotto.service.PurchasedLottoTickets;

public class WinningStatistics {
    private Map<String, Integer> counts;

    public WinningStatistics(PurchasedLottoTickets purchasedLottoTickets) {
        this.counts = purchasedLottoTickets.eachRankCount();
    }

    public void printStatistics() {
        System.out.println("3개 일치 (5,000원) - " + counts.get("5th") + "개");
        System.out.println("4개 일치 (50,000원) - " + counts.get("4th") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts.get("3rd") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get("2nd") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts.get("1st") + "개");
    }
}
