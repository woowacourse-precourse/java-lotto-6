package lotto.model;

import java.util.ArrayList;

public class LottoDecision {
    private final int[] winningNumber;
    private int[] winningData;
    private float rateOfReturn;

    public LottoDecision(int[] winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int[] getWinningNumber() {
        return winningNumber;
    }


    public void setWinningData(int[] winningData) {
        this.winningData = winningData;
    }

    public int[] getWinningData() {
        return this.winningData;
    }
}
