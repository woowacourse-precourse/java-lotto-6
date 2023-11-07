package lotto.dto;

import java.util.List;
import lotto.domain.EarningRate;
import lotto.domain.LottoTickets;
import lotto.domain.LuckyNumbers;
import lotto.domain.WinningStatistics;

public class Dto {
    private LuckyNumbers luckyNumbers;
    private LottoTickets lottoTickets;
    private WinningStatistics winningStatistics = new WinningStatistics();
    private EarningRate earningRate = new EarningRate();
    private List<Integer> numbers;
    private int bonus;

    public LuckyNumbers getLuckyNumbers() {
        return luckyNumbers;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public int getMoney() {
        return lottoTickets.getMoney();
    }

    public void setMoney(int money) {
        lottoTickets = new LottoTickets(money);
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setLuckyNumbers() {
        try {
            luckyNumbers = new LuckyNumbers(bonus, numbers);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public void makeWinningStatistics() {
        winningStatistics.makeWinningStatistics(lottoTickets, luckyNumbers);
    }

    public List<Integer> getWinningStatistics() {
        return winningStatistics.getWinningStatistics();
    }

    public long calculateEarningRate() {
        return earningRate.calculateEarningRate(winningStatistics.getWinningStatistics());
    }
}
