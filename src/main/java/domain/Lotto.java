package domain;

import utils.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkLottoSizeNumberInput(numbers);
        Validator.checkLottoDuplicatedNumberInput(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int match(List<Integer> list) {
        int count = 0;
        for (Integer integer : list) {
            if (numbers.contains(integer)) {
                count++;
            }
        }
        return count;
    }
}
