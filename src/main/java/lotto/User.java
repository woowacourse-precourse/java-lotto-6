package lotto;

import java.util.List;

public class User {

    private int purchaseAmount = 0;
    private int totalReturn = 0;
    private double totalReturnPercentage = 0;
    private List<Lotto> lottoList;
    private int[] winningStatistics;

    public int getTotalReturn() {
        return totalReturn;
    }

    public void setTotalReturn(int totalReturn) {
        this.totalReturn = totalReturn;
    }


    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int[] getWinningStatistics() {
        return winningStatistics;
    }

    public void setWinningStatistics(int[] winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public double getTotalReturnPercentage() {
        return totalReturnPercentage;
    }

    public void setTotalReturnPercentage(double totalReturnPercentage) {
        this.totalReturnPercentage = totalReturnPercentage;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
}
