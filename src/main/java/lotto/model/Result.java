package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public class Result {
    private static HashMap<Integer, Integer> winningCount = new HashMap<>();
    private static List<Lotto> lottoTickets = new ArrayList<>();
    private static int totalPrize;

    public void addWinningCount(int rank) {
        if (winningCount.containsKey(rank)) {
            winningCount.put(rank, winningCount.get(rank) + 1);
            return;
        }
        winningCount.put(rank, 1);
    }

    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public void addTotalPrize(int prize) {
        totalPrize += prize;
    }

    public HashMap<Integer, Integer> getWinningCount() {
        return winningCount;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTickets;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
