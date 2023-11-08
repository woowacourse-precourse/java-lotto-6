package lotto.domain;

import java.util.List;

import static lotto.message.ErrorMessage.LOTTO_NUMBERS_ARE_DUPLICATED_MESSAGE;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_ARE_NOT_ENOUGH_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> deduplicationList = numbers.stream().distinct().toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_NOT_ENOUGH_MESSAGE.getMessage());
        }

        if (numbers.size() != deduplicationList.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_DUPLICATED_MESSAGE.getMessage());
        }
    }

    public boolean isNumberExist(int number) {
        return numbers.contains(number);
    }

    public List<Integer> toList() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
