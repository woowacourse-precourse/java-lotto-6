package lotto.model;

import lotto.exception.InvalidPaymentAmountException;

import java.util.List;

public class LottoDecision {
    private final List<Integer> winningNumbers;
    private int[] winningData;

    public LottoDecision(List<Integer> winningNumbers) {
        validateWinningNumberLength(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumber() {
        return winningNumbers;
    }

    public void setWinningData(int[] winningData) {
        this.winningData = winningData;
    }

    public int[] getWinningData() {
        return this.winningData;
    }

    private void validateWinningNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 7자리여야 합니다.");
        }
    }
}
