package controller;

import Constant.Rank;
import java.util.HashMap;
import java.util.Map;
import model.Lotto;
import model.MyLotto;
import model.WinningNumbers;
import view.OutPutView;

public class CompareController {
    long totalWinnings;
    Map<Rank, Integer> winningDetails;

    public CompareController() {
        totalWinnings = 0;
        winningDetails = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningDetails.put(rank, 0);
        }
    }

    public void run(MyLotto myLotto, WinningNumbers winningNumbers) {
        lottoCompare(myLotto, winningNumbers);
        OutPutView.printWinningStatistics(winningDetails);
        OutPutView.printRateOfReturn(calculateRateOfReturn(myLotto));
    }

    public void lottoCompare(MyLotto myLotto, WinningNumbers winningNumbers) {
        for (Lotto lotto : myLotto.getMyLotto()) {
            int matchedNumberCount = countMatchingNumbers(lotto, winningNumbers);
            boolean is_bonus = compareBonusNumber(lotto, winningNumbers);
            classificationRank(matchedNumberCount, is_bonus);
        }
    }

    public int countMatchingNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        int matchedNumberCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchedNumberCount++;
            }
        }
        return matchedNumberCount;
    }

    public boolean compareBonusNumber(Lotto lotto, WinningNumbers winningNumbers) {
        if (lotto.getNumbers().contains(winningNumbers.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public void classificationRank(int matchedNumberCount, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.isCorrect(matchedNumberCount, bonus)) {
                winningDetails.put(rank, winningDetails.get(rank) + 1);
                totalWinnings += rank.getReward();
            }
        }
    }

    public double calculateRateOfReturn(MyLotto myLotto) {
        return ((double) totalWinnings / (myLotto.size() * 10));
    }
}