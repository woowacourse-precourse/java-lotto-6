package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 로또 입력 값은 중복 되지 않아야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 숫자는 1이상 45이하여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
