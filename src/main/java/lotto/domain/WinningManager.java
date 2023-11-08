package lotto.domain;

import java.util.List;

public class WinningManager {
    private final List<Integer> winningNumber;

    private final int bonusNumber;

    private int winningMoney;

    private double winningRate;

    public WinningManager(final List<Integer> winningNumber, final int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningMoney = 0;
    }

    public void calculateRevenue(Buyer buyer){
        for(int i=1; i<=5; i++){
            Integer rankAmount = buyer.getWinningLotto().get(i);
            if(rankAmount != null){
                winningMoney += rankAmount * PrizeRank.getPrizeMoney(i);
            }
        }
        this.winningRate = ((double)winningMoney / (double)(buyer.getLottoAmount()*1000)) * 100;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public double getWinningRate() {
        return winningRate;
    }
}
