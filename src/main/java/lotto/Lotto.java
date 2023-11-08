package lotto;

import java.util.List;

import static validate.InputValidation.validateLottoNumberCount;
import static validate.InputValidation.validateNoDuplicateNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateNoDuplicateNumbers(numbers);
    }

    // TODO: 추가 기능 구현

    public void printLottoNumbers() {
        System.out.println(numbers.toString());
    }

    public int countMatchingLottoNumbers(LottoResult result) {
        int count = 0;
        for (Integer number : numbers) {
            count = count + result.containResultNumbers(number);
        }
        return count;
    }

    public boolean hasBonusNumber(LottoResult result) {
        return result.hasBonusNumber(numbers);
    }
}
