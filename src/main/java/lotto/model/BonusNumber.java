package lotto.model;

import java.util.List;

public class BonusNumber {
    private int bonus;

    public BonusNumber(int bonus, List<Integer> winningNumbers) {
        this.bonus = bonus;
        validateDuplication(winningNumbers);
    }

    public int getBonus() {
        return bonus;
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복되지 않는 숫자만 가능합니다");
        }
    }
}
