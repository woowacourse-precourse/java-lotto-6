package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Buyer {
    private final int purchaseAmount;
    private int winningAmount;
    private final List<Lotto> lottoTickets;
    private final HashMap<WinningCondition, Integer> winningStatistics = new HashMap<>();

    public Buyer(int purchaseAmount, ArrayList<Lotto> lottoTickets) {
        this.purchaseAmount = purchaseAmount;
        this.lottoTickets = lottoTickets;

        for (WinningCondition winningCondition : WinningCondition.values()) {
            winningStatistics.put(winningCondition, 0);
        }
    }

    public int getLottoTicketCount() {
        return lottoTickets.size();
    }

    public List<List<Integer>> getLottoTicketNumbers() {
        List<List<Integer>> lottoTicketNumbers = new ArrayList<>();

        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            lottoTicketNumbers.add(numbers);
        }

        return lottoTicketNumbers;
    }

    public void computeLottoResults(int[] winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoTickets) {
            WinningCondition winningCondition = getWinningResult(lotto, winningNumbers, bonusNumber);
            updateWinningStatistics(winningCondition);
            updateWinningAmount(winningCondition.winningAmount());
        }
    }

    public HashMap<WinningCondition, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    private WinningCondition getWinningResult(Lotto lotto, int[] winningNumbers, int bonusNumber) {
        int winningNumberCount = getWinningNumberCount(lotto.getNumbers(), winningNumbers);
        int bonusNumberCount = getBonusNumberCount(lotto.getNumbers(), bonusNumber);
        return WinningCondition.valueOfLottoNumbers(winningNumberCount, bonusNumberCount);
    }

    public float getTotalProfitRate() {
        return winningAmount / (float) purchaseAmount * 100;
    }

    public int getWinningNumberCount(List<Integer> numbers, int[] winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public int getBonusNumberCount(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber))
            return 1;
        return 0;
    }

    public void updateWinningStatistics(WinningCondition winningCondition) {
        int value = winningStatistics.get(winningCondition);
        winningStatistics.put(winningCondition, value + 1);
    }

    public void updateWinningAmount(int winningAmount) {
        this.winningAmount += winningAmount;
    }


}
