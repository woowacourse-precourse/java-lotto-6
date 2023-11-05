package lotto.domain;

import java.util.List;

public class LottoManager {

    private final WinningDetails winningDetails;

    public LottoManager(WinningDetails winningDetails) {
        this.winningDetails = winningDetails;
    }

    public void addRankToWinningDetails(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            winningDetails.addRank(winningNumbers.determineRank(lotto));
        }
    }

    public String getWinningDetailsToString() {
        return winningDetails.toString();
    }
}
