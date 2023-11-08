package lotto.Domain;

import java.util.List;

import static lotto.Validator.ValidatorConstant.SIZE_ERROR;
import lotto.Validator.Validator;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.valiateDuplicateNums(numbers);
        Validator.validateNumbersRange(numbers);
        lottoSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void lottoSort(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_SIZE - 1; i++) {
            for (int j = i + 1; j < LOTTO_SIZE; j++) {
                minSwap(numbers, i, j);
            }
        }
    }

    private void minSwap(List<Integer> numbers, int i, int j) {
        if (numbers.get(i) > numbers.get(j)) {
            int tmp = numbers.get(i);
            numbers.set(i, numbers.get(j));
            numbers.set(j, tmp);
        }
    }

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
