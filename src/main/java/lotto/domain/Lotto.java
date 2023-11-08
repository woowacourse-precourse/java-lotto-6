package lotto.domain;

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
        if(isDuplicated(numbers))
            throw new IllegalArgumentException();
        if(!isAllInRange(numbers))
            throw new IllegalArgumentException();
    }

    // TODO: 추가 기능 구현

    boolean isDuplicated(final List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; ++i) {
            List<Integer> subNumbers = numbers.subList(i + 1, numbers.size());
            if(subNumbers.contains(numbers.get(i))) return true;
        }

        return false;
    }

    private boolean isAllInRange(final List<Integer> numbers){
        for (Integer number : numbers) {
            if(!isRange(number)) return false;
        }

        return true;
    }

    private boolean isRange(int number){
        return 1 <= number && number <= 45;
    }
    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
