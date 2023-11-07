package lotto;

import constValue.ConstNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        List<String> numbers = new ArrayList<>();
        for (Integer number : sortLotto(this.numbers)) {
            numbers.add(String.valueOf(number));
        }
        return "[" + String.join(", ", numbers) + "]";
    }

    public List<Integer> sortLotto(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            sortNumbers.add(number);
        }
        sortNumbers.sort(Comparator.naturalOrder());
        return sortNumbers;
    }

    public boolean findNumber(Integer number) {
        return this.numbers.contains(number);
    }

    private List<Integer> getNumbers() {
        return this.numbers;
    }

    public Integer compareCorrectLotto(Lotto correctlotto) {
        Integer counter = 0;
        for (Integer number : correctlotto.getNumbers()) {
            if (this.getNumbers().contains(number)) {
                counter++;
            }
        }
        return counter;
    }

    public Integer calculateGrade(Lotto correctlotto, Integer bonusNumber) {
        if (getNumbers().contains(bonusNumber) && compareCorrectLotto(correctlotto) == 5) {
            return ConstNumber.SECOND_GRADE.getValue();
        }
        if (compareCorrectLotto(correctlotto) == 6) {
            return ConstNumber.FIRST_GRADE.getValue();
        }
        if (compareCorrectLotto(correctlotto) == 5) {
            return ConstNumber.THIRD_GRADE.getValue();
        }
        if (compareCorrectLotto(correctlotto) == 4) {
            return ConstNumber.FOURTH_GRADE.getValue();
        }
        if (compareCorrectLotto(correctlotto) == 3) {
            return ConstNumber.FIFTH_GRADE.getValue();
        }
        return ConstNumber.LOSE.getValue();
    }
}
