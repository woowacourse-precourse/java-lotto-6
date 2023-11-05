package lotto.domain;

import static lotto.constants.Error.DUPLICATION_ERROR;
import static lotto.constants.Error.SIZE_ERROR;

import java.util.HashSet;
import java.util.List;
import lotto.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void checkInclusion(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }

    public static void checkLottoNumber(String lottoNumber) {
        Validator.checkNumber(lottoNumber);
        Validator.checkZero(lottoNumber);
        Validator.checkRange(Integer.parseInt(lottoNumber));
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR.getMessage());
        }
    }

    private void checkDuplication(List<Integer> userInput) {
        if (userInput.size() != new HashSet<>(userInput).size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }
}
