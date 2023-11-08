package lotto.outputPrint;

import java.util.Map;
import lotto.service.PurchasedLottoTickets;
import lotto.service.Reward;

public class WinningStatistics {
    public void printStatistics(PurchasedLottoTickets purchasedLottoTickets) {

        Map<Reward, Integer> counts = purchasedLottoTickets.eachRankCount();
        System.out.println("3개 일치 (5,000원) - " + counts.get(Reward.FIFTH_PLACE) + "개");
        System.out.println("4개 일치 (50,000원) - " + counts.get(Reward.FOURTH_PLACE) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts.get(Reward.THIRD_PLACE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(Reward.SECOND_PLACE) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts.get(Reward.FIRST_PLACE) + "개");
    }
}
