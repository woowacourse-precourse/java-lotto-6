package lotto.model;

import java.util.ArrayList;

public class LottoDecision {
    private final int[] winningNumber;
    private int[] winningGrade;
    private float rateOfReturn;

    public LottoDecision(int[] winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int[] getWinningNumber() {
        return winningNumber;
    }


    public void setWinningGrade(int[] winningGrade) {
        this.winningGrade = winningGrade;
    }

    public int[] getWinningGrade() {
        return this.winningGrade;
    }
}
