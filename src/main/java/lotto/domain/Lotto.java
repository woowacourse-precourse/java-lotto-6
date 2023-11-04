package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        int WINNING_NUMBERS_SIZE = 6;   // enum으로 작성하자

        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다. 다시 입력해주세요.");
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복할 수 없습니다. 다시 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
