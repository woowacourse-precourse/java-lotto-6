package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Bonus {

    private final List<Integer> numbers;
    private final int bonus;

    public Bonus(List<Integer> numbers, int bonus) {
        rangeCheck(numbers);
        duplicateCheck(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void duplicateCheck(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨번호랑 중복입니다.");
        }
    }

    private void rangeCheck(List<Integer> numbers) {
        for (Integer Num : numbers) {
            if (Num < 1 || Num > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위 오류입니다.");
            }
        }
    }
}
