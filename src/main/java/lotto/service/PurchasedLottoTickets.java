package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.readUserInput.PurchaseAmount;

public class PurchasedLottoTickets {
    private List<Lotto> tickets = new ArrayList<>();

    public void register(PurchaseAmount purchaseAmount) {
        while (purchaseAmount.addTicketByPurchaseAmount(tickets.size())) {
            RandomNumbers randomNumbers = new RandomNumbers();
            Lotto lotto = new Lotto(randomNumbers.draw());
            tickets.add(lotto);
        }
    }

    public Map<Reward, Integer> eachRankCount() {
        Map<Reward, Integer> counts = new HashMap<>();
        setZero(counts);
        tickets.stream()
                .map(CompareWinningNumbers::new)
                .forEach((winningNumbers) -> {
                    Reward rank = winningNumbers.checkThisTicketRank();
                    counts.put(rank, counts.get(rank) + 1);
                });
        return counts;
    }

    public void setZero(Map<Reward, Integer> counts) {
        counts.put(Reward.FIRST_PLACE, CompareCount.INITIAL_ZERO_COUNT.getCount());
        counts.put(Reward.SECOND_PLACE, CompareCount.INITIAL_ZERO_COUNT.getCount());
        counts.put(Reward.THIRD_PLACE, CompareCount.INITIAL_ZERO_COUNT.getCount());
        counts.put(Reward.FOURTH_PLACE, CompareCount.INITIAL_ZERO_COUNT.getCount());
        counts.put(Reward.FIFTH_PLACE, CompareCount.INITIAL_ZERO_COUNT.getCount());
        counts.put(Reward.LOSE, CompareCount.INITIAL_ZERO_COUNT.getCount());
    }

    public void textForTicketsPrint() {
        for (Lotto lotto : tickets) {
            System.out.println(lotto.sortLottoNumbers());
        }
    }

    public int allTicketCount() {
        return tickets.size();
    }
}
