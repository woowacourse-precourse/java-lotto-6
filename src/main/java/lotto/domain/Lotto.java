package lotto.domain;

import java.util.List;
import lotto.domain.exception.ExceptionFormat;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        verifyDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void verifyDuplicatedNumber(List<Integer> numbers) throws IllegalArgumentException {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    throw new IllegalArgumentException(ExceptionFormat.formatException("로또 번호에 중복된 숫자가 있으면 안 됩니다."));
                }
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int getSize() {
        return this.numbers.size();
    }


}
