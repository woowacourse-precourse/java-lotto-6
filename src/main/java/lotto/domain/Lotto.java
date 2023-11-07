package lotto.domain;

import java.util.List;
import lotto.exception.InputLottoNumException;

public class Lotto {
    private static int bonusNum;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputLottoNumException inputLottoNumException = new InputLottoNumException();
        inputLottoNumException.validateLotto(numbers);
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
