package lotto.Domain;

import java.util.List;

import lotto.Validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.valiateDuplicateNums(numbers);
        Validator.validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public int calculateLottoResults(List<Integer> lottoWinningNumbers) {
        int result = 0;
        for (int number : lottoWinningNumbers) {
            result += containCheck(number);
        }
        return result;
    }

    private int containCheck(int number) {
        if (isContain(number)) {
            return 1;
        }
        return 0;
    }

    public boolean bonusNumberCheck(int bonusNumber) {
        return isContain(bonusNumber);
    }

    private boolean isContain(int number) {
        return numbers.contains(number);
    }
}
