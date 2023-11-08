package lotto.model.lottoResultChecker;


import java.util.List;

public class LottoBonus {
    private final int bonusNumber;

    public LottoBonus(String input, List<Integer> winningNumbers) {
        int number = parseBonusNumber(input);
        validateBonusNumber(number, winningNumbers);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int parseBonusNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private void validateBonusNumber(int number, List<Integer> winningNumbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}






