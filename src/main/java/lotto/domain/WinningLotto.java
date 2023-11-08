package lotto.domain;

import java.util.List;

import static lotto.constant.LottoConst.*;

public class WinningLotto {

    private final Lotto winning;

    private final int bonus;

    public WinningLotto(List<Integer> numbers, String bonus) {
        this.winning = new Lotto(numbers);
        int numberBonus = validateBonus(bonus);
        validateDuplicateBonus(numberBonus);
        validateRangeBonus(numberBonus);
        this.bonus = numberBonus;
    }

    public Lotto getWinning() {
        return this.winning;
    }

    public int getBonus() {
        return this.bonus;
    }

    private void validateRangeBonus(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(IS_DUPLICATE);
        }
    }

    private void validateDuplicateBonus(int bonus) {
        if (this.winning.find(bonus)) {
            throw new IllegalArgumentException(OVER_RANGE);
        }
    }

    private int validateBonus(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }

    }


}
