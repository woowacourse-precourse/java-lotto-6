package lotto.domain;

import lotto.utils.StringUtils;

public class Bonus {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private int bonusNumber;

    public Bonus(Winning winning, String input) {
        bonusNumber = validate(winning, input);
    }

    private int validate(Winning winning, String input) {
        int bonus = StringUtils.stringToNumber(input);

        if (winning.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않습니다.");
        }

        if (bonus < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < bonus) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자입니다.");
        }

        return bonus;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
