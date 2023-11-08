package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.ErrorMessageContainer.DUPLICATE_LOTTO_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateChecker(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRole.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void duplicateChecker(List<Integer> numbers) {
        List<Integer> checkedList = new ArrayList<>();
        for (int i = 0; i < LottoRole.LOTTO_SIZE.getNumber(); i++) {
            if (checkedList.contains(numbers.get(i))) {
                throw new IllegalArgumentException();
            } else {
                checkedList.add(numbers.get(i));
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
