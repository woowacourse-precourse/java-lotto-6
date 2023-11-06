package domain;

import domain.validator.LottoValidator;

import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.checkLottoValidation(numbers);
        this.numbers = sortLottoNumberByAscendingOrder(numbers);
    }

    private List<Integer> sortLottoNumberByAscendingOrder(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
