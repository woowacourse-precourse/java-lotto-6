package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate();
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int countMatchNumber(WinnigNumber winnigNumber) {
        return (int) numbers.stream()
                .filter(winnigNumber::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }


    public void validate() {
        validateNumberOfNumber(numbers);
    }

    private void validateNumberOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}

