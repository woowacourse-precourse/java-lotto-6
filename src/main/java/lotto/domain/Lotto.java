package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Utils.ascendingOrder;

public class Lotto {
    public final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascendingOrder(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != Buyer.LOTTO_COUNT;
    }

}
