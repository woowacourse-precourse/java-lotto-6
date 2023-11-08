package lotto.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningRecords {

    private final int[] lotteryResults = new int[7];
    private int matchFiveWithBonus = 0;
    private final int bonusNumber;
    private final List<Integer> winningNumbersWithBonusNumber;


    public WinningRecords(List<List<Integer>> lottoTickets,
                          int bonusNumber,
                          List<Integer> winningNumbersWithBonusNumber) {

        this.winningNumbersWithBonusNumber = winningNumbersWithBonusNumber;
        this.bonusNumber = bonusNumber;

        calculateWinningRecords(lottoTickets);
    }

    private void calculateWinningRecords(List<List<Integer>> lottoTickets) {
        for (List<Integer> lotto : lottoTickets) {
            Set<Integer> matchResults = new HashSet<>(winningNumbersWithBonusNumber);
            matchResults.addAll(lotto);

            int countMatch = 13 - matchResults.size();

            if (countMatch == 5 && lotto.contains(bonusNumber)) {
                matchFiveWithBonus++;
            } else if (countMatch > 0) {
                lotteryResults[countMatch] += 1;
            }
        }
    }

    public int getMatchFiveWithBonus() {
        return matchFiveWithBonus;
    }

    public int[] getLotteryResults() {
        return lotteryResults;
    }
}
