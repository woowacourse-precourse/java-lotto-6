package lotto.model;

import static lotto.constant.CommonUnits.MAX_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.MIN_LOTTO_NUMBER;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER +
                "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.");
        }
    }
}
