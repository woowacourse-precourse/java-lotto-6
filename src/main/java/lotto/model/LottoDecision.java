package lotto.model;

import lotto.validation.Validator;
import java.util.List;

public class LottoDecision {
    private static final String WINNING_NUMBER = "당첨";
    private final List<Integer> winningNumbers;
    private int[] winningData;

    public LottoDecision(List<Integer> winningNumbers) {
        validateWinningNumberLength(winningNumbers);
        Validator.validateDuplicateNumber(winningNumbers, WINNING_NUMBER);
        Validator.validateNumberInRange(winningNumbers, WINNING_NUMBER);
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
