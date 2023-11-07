package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private final static int PERMITTED_LOTTO_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate2(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validate2(List<Integer> numbers) {
        if(hasDuplicate(numbers))
        {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }
    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}
