package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        if(Collections.max(numbers)>45 || Collections.min(numbers)<1)
            throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해야 합니다.");
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> checkNumber = new HashSet<>(numbers);
        if(checkNumber.size()!=numbers.size())
            throw new IllegalArgumentException("[ERROR] 중복하지 않은 숫자를 입력해야 합니다.");
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
