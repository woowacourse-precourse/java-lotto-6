package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final int LOTTOSIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Output.printCustomerLottos(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTOSIZE) {
            throw new IllegalArgumentException();
        }

        validateDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {

        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {

            if (!set.add(number)) {

                throw new IllegalArgumentException();
            }
        }
    }

    public boolean compareNum(int num) {

        return numbers.contains(num);
    }

    public boolean compareBonusNum(int bonusNumber) {

        return numbers.contains(bonusNumber);
    }
}
