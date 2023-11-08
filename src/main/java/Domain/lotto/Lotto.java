package Domain.lotto;

import Util.CheckInteger;
import Util.CheckList;
import View.WinningNumberInputErrorText;

import java.util.List;
/*
    제공된 lotto class
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        CheckList.checkDuplicate(numbers, WinningNumberInputErrorText.dupilicateNumber());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
