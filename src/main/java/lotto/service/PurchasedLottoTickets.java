package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.readUserInput.PurchaseAmount;

public class PurchasedLottoTickets {
    private List<Lotto> tickets = new ArrayList<>();

    public void register() {
        while (tickets.size() < PurchaseAmount.lottoQuantity) {
            Lotto lotto = new Lotto(RandomNumbers.draw());
            tickets.add(lotto);
        }
    }

    public Map<String, Integer> eachRankCount() {
        Map<String, Integer> counts = new HashMap<>();
        for (Lotto lotto : tickets) {
            CompareWinningNumbers compareWinningNumbers = new CompareWinningNumbers(lotto);
            String rank = compareWinningNumbers.checkThisTicketRank();
            if (!counts.containsKey(rank)) {
                counts.put(rank, 0);
            }
            counts.put(rank, counts.get(rank) + 1);
        }
        return counts;
    }
}
