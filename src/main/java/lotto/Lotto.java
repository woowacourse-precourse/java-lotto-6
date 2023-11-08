package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Constant.ERROR;
import static lotto.util.Constant.LOTTO_LENGTH;
import static lotto.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.util.Constant.MIN_LOTTO_NUMBER;

public class Lotto {

    public static final String LOTTO_DUPLICATED_MESSAGE = ERROR + "중복된 숫자를 입력할 수 없습니다.";
    private static final String LOTTO_RANGE_MESSAGE = ERROR + "로또 범위는 1 ~ 45 사이의 6개여야 가능합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = checkDuplicated(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH || !numbers.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_RANGE_MESSAGE);
        }
    }

    private List<Integer> checkDuplicated(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() == set.size()) {
            return numbers;
        }
        throw new IllegalArgumentException(LOTTO_DUPLICATED_MESSAGE);
    }
}
