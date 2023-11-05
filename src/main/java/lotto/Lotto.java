package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    }

    // TODO: 추가 기능 구현

    public int matchCount(List<Integer> winnings) {
        int ret = 0;
        for (Integer w : winnings) {
            if (numbers.contains(w)) {
                ret += 1;
            }
        }
        return ret;
    }

    public boolean matchBonus(Integer bonus) {
        return numbers.contains(bonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
