package lotto;

import static lotto.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException();
            }
        }

    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }



}
