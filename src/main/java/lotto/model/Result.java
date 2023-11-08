package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public class Result {
    private HashMap<Integer, Integer> winningCount = new HashMap<>();
    private List<Lotto> lottoTickets = new ArrayList<>();
    private int totalPrize;
    private String totalProfit;

    public void setWinningCount(HashMap<Integer, Integer> winningCount) {
        this.winningCount = winningCount;
    }

    public HashMap<Integer, Integer> getWinningCount() {
        return winningCount;
    }

    public void setLottoTicket(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTickets;
    }

    public void setTotalPrize(int prize) {
        this.totalPrize = prize;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public String getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(String totalProfit) {
        this.totalProfit = totalProfit;
    }
}
