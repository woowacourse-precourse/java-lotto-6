package lotto.domain;

import static lotto.Exception.ExceptionMessage.*;
import static lotto.utils.Constance.LOTTO_MAX_NUMBER;
import static lotto.utils.Constance.LOTTO_MIN_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.lang.Integer;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateLottoLength(numbers);
        validateDuplicationNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedLottoNumber() {
        return numbers.stream().sorted().toList();
    }

    public int getMatchingNumberCount(Lotto lotto) {
        List<Integer> myLottoNumbers = new ArrayList<>(this.numbers);
        myLottoNumbers.retainAll(lotto.getSortedLottoNumber());
        return myLottoNumbers.size();
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR.getExceptionMessage());
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATION_LOTTO_NUMBER.getExceptionMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isInvalid = numbers.stream()
                .anyMatch(i -> i < LOTTO_MIN_NUMBER.getValue() || i > LOTTO_MAX_NUMBER.getValue());

        if (isInvalid) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getExceptionMessage());
        }
    }


}
