package lotto.domain;

import java.util.Iterator;
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
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        String lottoNumbers = "[";
        Iterator iterator = numbers.iterator();
        lottoNumbers += iterator.next();
        while (iterator.hasNext()) {
            lottoNumbers += ", ";
            lottoNumbers += iterator.next();
        }
        lottoNumbers += "]";
        return lottoNumbers;
    }
}
