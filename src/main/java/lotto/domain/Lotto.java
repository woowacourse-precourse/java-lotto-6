package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.getInstance().validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public int countSameNumber(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(num -> winningNumbers.contains(num)).count();
    }

    public boolean containsBonus(int bonusNumber) {

        return numbers.contains(bonusNumber);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {

        return numbers;
    }
}
