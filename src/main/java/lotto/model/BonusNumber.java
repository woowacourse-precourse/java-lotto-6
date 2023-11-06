package lotto.model;

import java.util.List;

public class BonusNumber {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;
    private final int bonus;

    public BonusNumber(int bonus, List<Integer> winningNumbers) {
        this.bonus = bonus;
        validateOutOfRange(bonus);
        validateDuplication(winningNumbers);
    }

    public int getBonus() {
        return bonus;
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자만 가능합니다");
        }
    }

    private void validateOutOfRange(int bonus) {
        if (bonus < MIN_RANGE || bonus > MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자 하나만 가능합니다");
        }
    }
}
