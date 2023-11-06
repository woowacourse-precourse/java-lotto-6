package lotto.model;

import java.util.ArrayList;

public class LottoDecision {
    private final int[] winningNumber;
    private ArrayList<Integer> winningStatistic;

    public LottoDecision(int[] winningNumber) {
        this.winningNumber = winningNumber;
    }

    public ArrayList<Integer> setWinningStatistic() {
        return winningStatistic;
    }

    public ArrayList<Integer> getWinningStatistic() {
        return winningStatistic;
    }
}
