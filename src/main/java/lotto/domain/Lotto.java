package lotto.domain;

import java.util.HashSet;
import java.util.List;

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
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) throw new IllegalArgumentException("[ERROR] 중복값이 존재합니다.");
    }

    public Integer countMatchingNumber(Lotto winningLotto, Integer bonusNumber) {
        int matchCount = (int) winningLotto.numbers.stream().filter(this.numbers::contains).count();
        if (this.numbers.contains(bonusNumber)) matchCount++;
        return matchCount;
    }

    public Boolean checkMatchingNumber(Integer bonusNumber) {
        if (this.numbers.contains(bonusNumber)) return true;
        return null;
    }
}
