package lotto.service;

import lotto.domain.WinningList;

public class WinningService {
    WinningList winningList;
    public WinningService(WinningList winningList) {
        this.winningList = winningList;
    }
    public void plusWinningCounts(int[] winningCounts) {
        for(int i = 0; i < winningCounts.length; i++) {
            if(winningCounts[i] > 2) {
                winningList.plusWinningCount(winningCounts[i]);
            }
        }
    }
}
