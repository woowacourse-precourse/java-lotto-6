package domain;

import domain.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        LottoValidator.checkLottoValidation(mutableNumbers);
        this.numbers = sortLottoNumberByAscendingOrder(mutableNumbers);
    }

    private List<Integer> sortLottoNumberByAscendingOrder(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }
}
