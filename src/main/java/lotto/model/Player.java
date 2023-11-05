package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int budget;
    private int usedBudget;
    private List<Lotto> lottoTickets;
    private WinningStatistics winningStatistics;

    public Player() {
        budget = 0;
        usedBudget = 0;
        lottoTickets = new ArrayList<>();
        winningStatistics = WinningStatistics.createDefaultWinningStatistics();
    }

    public void buyLottoTickets(LottoShop lottoShop) {
        List<Lotto> purchased = lottoShop.createLottoTickets(budget);
        usedBudget += purchased.size() * lottoShop.getLottoPrice();
        lottoTickets.addAll(purchased);
    }

    public void calculateWinningLottoWithMine(WinningLotto winningLotto) {
        winningStatistics = new WinningStatistics(winningLotto, lottoTickets, usedBudget);
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}