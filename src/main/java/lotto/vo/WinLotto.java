package lotto.vo;

import java.util.List;
import lotto.validator.WinLottoValidator;

public class WinLotto {
    private final List<Integer> numbers;
    private final int bonusNum;

    public WinLotto(List<Integer> numbers, int bonusNum) {
        validate(numbers, bonusNum);
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    private void validate(List<Integer> numbers, int bonusNum) {
        WinLottoValidator.validate(numbers, bonusNum);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}