package lotto.domain;

import java.util.HashMap;

public class WinningList {
    HashMap<Integer,Integer> winningList;
    public WinningList(HashMap<Integer, Integer> winningList) {
        this.winningList = winningList;
        settingWinningList();
    }
    private HashMap<Integer,Integer> settingWinningList() {
        final int WINNING_BONUS_NUM = 9;
        final int MAX_WINNING_NUM = 6;

        winningList.put(WINNING_BONUS_NUM, 0);
        for(int winningNum = 3; winningNum <= MAX_WINNING_NUM; winningNum++) {
            winningList.put(winningNum, 0);
        }
        return winningList;
    }
    public void plusWinningCount(int winningNum) {
        winningList.put(winningNum, (winningList.get(winningNum) + 1));
    }

    public int getWinningCount(int winningNum) {
        return winningList.get(winningNum);
    }

}
