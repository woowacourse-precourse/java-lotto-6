package lotto.model.lotto;


import lotto.util.Log;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final Log log = new Log();

    public Lotto(List<Integer> numbers) {
        checkDuplicates(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkDuplicates(List<Integer> lottoNumber) {
        Set<Integer> checkDuplicateNumber = new HashSet<>(lottoNumber);
        if (lottoNumber.size() != checkDuplicateNumber.size()) {
            log.error("중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
    }
}
