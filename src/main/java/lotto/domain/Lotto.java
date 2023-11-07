
package lotto.domain;

import lotto.utils.ListUtil;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ListUtil.checkLength(numbers);
        ListUtil.checkRange(numbers);
        ListUtil.checkDuplicateValue(numbers);
    }
    public List<Integer> getLotto() {
        return numbers;
    }
}