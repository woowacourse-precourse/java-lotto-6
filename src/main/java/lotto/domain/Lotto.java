package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(numbers);
        validateNumberSize(numbers);
        validateRepetition(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        int validatedSize = Math.toIntExact(numbers.stream()
                .filter(x -> x <= 45)
                .filter(x -> x >= 1)
                .count());

        if(validatedSize != numbers.size()) {
            throw new IllegalArgumentException("[Error] 각 숫자는 1~45 사이여야 합니다.");
        }
    }

    private void validateRepetition(List<Integer> numbers) {
        int validatedSize = Math.toIntExact(numbers.stream()
                .distinct()
                .count());

        if(validatedSize != numbers.size()) {
            throw new IllegalArgumentException("[ERROR]: 중복이 되지 않는 숫자로 입력해주세요!");
        }
    }
}
