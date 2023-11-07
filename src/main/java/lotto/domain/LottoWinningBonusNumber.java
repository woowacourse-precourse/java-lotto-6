package lotto.domain;

import java.util.List;

public class LottoWinningBonusNumber {
    private final int winningBonusNumber;

    public LottoWinningBonusNumber(String winningBonusNumberString, List<Integer> winningNumbers) {
        validateOnlyPositiveNumberBonus(winningBonusNumberString);
        int winningBonusNumber = convertToInteger(winningBonusNumberString);
        validateBonusNumberRange(winningBonusNumber);
        validateWinningBonusNumberAlreadyExists(winningBonusNumber, winningNumbers);
        this.winningBonusNumber = winningBonusNumber;
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }

    private void validateOnlyPositiveNumberBonus(String numbersString) {
        if (!numbersString.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력되어야 합니다.");
        }
    }

    private int convertToInteger(String winningBonusNumberString) {
        return Integer.parseInt(winningBonusNumberString);
    }

    private void validateBonusNumberRange(int winningBonusNumber) {
        if (winningBonusNumber < 1 || winningBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateWinningBonusNumberAlreadyExists(int winningBonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(winningBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 존재합니다.");
        }
    }
}
