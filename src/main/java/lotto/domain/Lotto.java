
package lotto.domain;

import lotto.constants.ErrorConstants;
import lotto.utils.ListUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
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