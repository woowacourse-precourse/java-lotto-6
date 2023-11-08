package lotto.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningRecords {

    private final int[] lotteryResults;
    private int matchFiveWithBonus = 0;

    private List<List<Integer>> lottoTickets;
    private int bonusNumber;
    private List<Integer> winningNumbersWithBonusNumber;


    public WinningRecords(List<List<Integer>> lottoTickets,
                          int bonusNumber,
                          List<Integer> winningNumbersWithBonusNumber,
                          int[] lotteryResults) {
        this.winningNumbersWithBonusNumber = winningNumbersWithBonusNumber;
        this.lottoTickets = lottoTickets;
        this.bonusNumber = bonusNumber;
        this.lotteryResults = lotteryResults;

        calculateWinningRecords();
    }

    private void calculateWinningRecords() {
        Set<Integer> matchResults = new HashSet<>(winningNumbersWithBonusNumber);
        for (List<Integer> lotto : lottoTickets) {
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
