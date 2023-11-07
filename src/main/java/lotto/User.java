package lotto;

import java.util.List;

public class User {

    private int totalReturnPercentage = 0;
    private List<Lotto> lottoList;
    private List<Integer> winningStatistics;

    public List<Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public void setWinningStatistics(List<Integer> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public int getTotalReturnPercentage() {
        return totalReturnPercentage;
    }

    public void setTotalReturnPercentage(int totalReturn) {
        this.totalReturnPercentage = totalReturn;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
}
