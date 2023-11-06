package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 로또 번호가 6개가 아닙니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[Error] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[Error] 로또 번호는 1부터 45까지입니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
