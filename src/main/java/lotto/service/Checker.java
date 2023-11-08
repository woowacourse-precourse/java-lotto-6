package lotto.service;

import static lotto.view.View.showResults;
import static lotto.view.View.showTotalProfit;
import static lotto.view.constants.ViewConstants.SHOW_THE_WINNING_STATISTICS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class Checker {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final BonusNumber bonusNumber;
    private final WinningNumbers winningNumbers;
    private final List<Lotto>lottoTickets;

    private final Integer[]matchs;

    public Checker(BonusNumber bonusNumber, WinningNumbers winningNumbers, List<Lotto>lottoTickets) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
        this.lottoTickets = lottoTickets;
        matchs = new Integer[LOTTO_NUMBERS_SIZE+2];
    }

    public void checkLottoTickets(){
        Arrays.fill(matchs, 0);
        for(int i = 0; i< lottoTickets.size();i++){
            if(isMatch(lottoTickets.get(i)) == 5)
                isBonusMatch(lottoTickets.get(i));
        }
        showResults(SHOW_THE_WINNING_STATISTICS, matchs);
    }
    private int isMatch(Lotto lotto){
        Set<Integer> win = new HashSet<>(winningNumbers.getWinningNumbers());
        win.addAll(lotto.getNumbers());
        int match = 2* LOTTO_NUMBERS_SIZE - win.size();
        matchs[match]++;
        return match;
    }
    private void isBonusMatch(Lotto lotto){
        List<Integer>temp = lotto.getNumbers();
        for(int i=0;i<LOTTO_NUMBERS_SIZE;i++){
            if(temp.get(i) == bonusNumber.getBonusNumber()) {
                matchs[5]--;
                matchs[7]++;
                break;
            }
        }
    }

    public void calculateToTalProfit(PurchaseAmount purchaseAmount){
        long totalWinningAmount = calculateTotalWinningAmount(matchs);
        int initialInvestment = purchaseAmount.getPurchaseAmount();
        double profitRate = (double) totalWinningAmount / initialInvestment;
        double totalProfitPercentage = (profitRate * 100);

        // 소수점 둘째 자리에서 반올림
        double roundedTotalProfit = Math.round(totalProfitPercentage * 100.0) / 100.0;
        showTotalProfit(roundedTotalProfit);
    }

    private long calculateTotalWinningAmount(Integer[] matchs){
        long totalWinningAmount = 0;
        totalWinningAmount+=matchs[3]*5000;
        totalWinningAmount+=matchs[4]*50000;
        totalWinningAmount+=matchs[5]*1500000;
        totalWinningAmount+=matchs[6]*2000000000;
        totalWinningAmount+=matchs[7]*30000000;
        return totalWinningAmount;
    }
}
