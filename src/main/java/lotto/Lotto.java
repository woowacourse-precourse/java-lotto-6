package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkSize(numbers);
        isNumberInRange(numbers);
        this.numbers = numbers;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != Config.SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_SIZE_INCORRECT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLotto() {
        return numbers;
    }

    private void isNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Config.MIN_LOTTO_NUMBER || number > Config.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_OUT_OF_RANGE_LOTT_NUMBER.getMessage());
            }
        }
    }
}
