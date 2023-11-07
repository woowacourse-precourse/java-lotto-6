package lotto.model;

import lotto.model.enums.LottoSpec;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        validateBonusInRange(bonus);
        validateBonusDuplicate(numbers, bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void validateBonusDuplicate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    private void validateBonusInRange(int bonus) {
        if (bonus < LottoSpec.MIN_NUMBER.getValue() || bonus > LottoSpec.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
