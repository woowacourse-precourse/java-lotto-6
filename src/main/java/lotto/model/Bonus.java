package lotto.model;

import java.util.List;

public class Bonus {

    private static final String INPUT_CONTENT_REGEX = "^[0-9]+$";
    
    private final int bonus;

    public Bonus(List<Integer> numbers, String bonus) {
        validateNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
        validateRange(this.bonus);
        validateDuplicate(numbers, this.bonus);
    }

    private void validateNumber(String bonus) {
        if (!bonus.matches(INPUT_CONTENT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨번호랑 중복입니다.");
        }
    }

    private void validateRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위 오류입니다.");
        }
    }
}
