package lotto.dto;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;

public class LottoDto {

    private List<List<Integer>> lottoTickets;
    private Map<Rank, Integer> winningStatistics;
    private int purchaseAmount;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }

    public void setLottoTickets(List<List<Integer>> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public void setWinningStatistics(Map<Rank, Integer> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        new PurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        new Lotto(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        new BonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }
}
