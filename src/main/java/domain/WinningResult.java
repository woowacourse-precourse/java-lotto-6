package domain;

import java.util.HashMap;
import java.util.List;

public class WinningResult {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private final HashMap<Rank, Integer> winningResult;
    private double totalPrize;
    private double rateOfProfit;

    private WinningResult(WinningNumbers winningNumbers, BonusNumber bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.winningResult = new HashMap<>();
        initWinningResult();
    }

    public static WinningResult create(WinningNumbers winningNumbers, BonusNumber bonusNumber){
        return new WinningResult(winningNumbers, bonusNumber);
    }

    public double getRateOfProfit(){
        return rateOfProfit;
    }

    public HashMap<Rank, Integer> getWinningResult(){
        return winningResult;
    }

    private void initWinningResult(){
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, 0);
        }
    }

    public void calculateProfit(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            calculate(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    public void calculateRateOfProfit(int amount){
        rateOfProfit = (totalPrize / (double) amount) * 100;
    }

    private void calculate(int countOfMatchNumber, boolean isMatchBonus){
        Rank rank = Rank.calculateRank(countOfMatchNumber, isMatchBonus);
        if(rank != null){
            winningResult.put(rank, winningResult.get(rank) + 1);
            addTotalPrize(rank.getPrize());
        }
    }

    private void addTotalPrize(int prize){
        totalPrize += prize;
    }

    private int getMatchNumbers(Lotto lotto, WinningNumbers winningNumbers){
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNums = winningNumbers.getNumbers();
        long matchedCount = lottoNumbers.stream()
                .filter(winningNums::contains)
                .count();
        return (int) matchedCount;
    }

    private boolean isMatchBonusNumber(Lotto lotto, BonusNumber bonusNumber){
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}
