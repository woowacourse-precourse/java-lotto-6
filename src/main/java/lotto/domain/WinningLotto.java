package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winning;

    private int bonus;

    public WinningLotto(List<Integer> numbers,String bonus) {
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
            throw new IllegalArgumentException("수의 범위는 1 ~ 45 입니다.");
        }
    }

    private void validateDuplicateBonus(int bonus) {
        if (this.winning.find(bonus)) {
            throw new IllegalArgumentException("중복된 수를 입력하셨습니다.");
        }
    }

    private int validateBonus(String number) {
        try {
            int intNumber = Integer.parseInt(number);
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }

    }


}
