package lotto;

import Exception.ContainDuplicatedNumberException;
import Exception.InvalidLottoNumberCountException;
import Exception.OutOfRangeNumberException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCountException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set set = new HashSet(numbers);
        if (numbers.size() != set.size()) {
            throw new ContainDuplicatedNumberException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i < MIN_NUMBER || i > MAX_NUMBER) {
                throw new OutOfRangeNumberException();
            }
        }
    }
}
