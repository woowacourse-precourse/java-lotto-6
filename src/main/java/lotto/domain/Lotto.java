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
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.");
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
