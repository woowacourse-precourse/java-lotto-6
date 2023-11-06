package lotto.model.domain;

import java.util.List;
import lotto.util.InputValidator;

public class Bonus implements InputValidator {

    private Integer number;

    @Override
    public boolean getInputUntilValid() {
        return number == null;
    }

    public int getNumber() {
        return number;
    }

    public void setBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        int bonus = validateBonusIsNumeric(bonusNumber);
        validateNumberBetweenInRange(bonus, 1, 45);
        validateWinningNumbersContainBonusNumber(winningNumbers, bonus);
        this.number = bonus;
    }

    private void validateNumberBetweenInRange(int bonus, int min, int max) {
        if(bonus < min || bonus > max) {
            throw new IllegalArgumentException("[ERROR] 1에서 45사이의 숫자로 입력해주세요.");
        }
    }

    private int validateBonusIsNumeric(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateWinningNumbersContainBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함되지 않는 번호를 입력해주세요.");
        }
    }

}
