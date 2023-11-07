package lotto.model.lottoResultChecker;

import java.util.List;

public class LottoBonus {
    private final int bonusNumber;

    public LottoBonus(String input, List<Integer> winningNumbers) {
        this.bonusNumber = parseAndValidateBonusNumber(input, winningNumbers);
    }

    private int parseAndValidateBonusNumber(String input, List<Integer> winningNumbers) {
        validateEmptyInput(input);
        int parsedBonusNumber = parseBonusNumber(input);
        ensureValidRange(parsedBonusNumber);
        ensureNotInWinningNumbers(parsedBonusNumber, winningNumbers);
        return parsedBonusNumber;
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다. 다시 입력해주세요.");
        }
    }

    private int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private void ensureValidRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
        }
    }

    private void ensureNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}