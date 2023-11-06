package lotto.model;

import static lotto.constants.LottoRule.LOTTO_NUMBER_LENGTH;
import static lotto.exception.ExceptionMessage.NUMBER_DUPLICATE_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateIsNumbersUnique(numbers);
        validateNumbersSize(numbers);

        this.numbers = numbers;
    }

    private void validateIsNumbersUnique(final List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public boolean isContainsNumber(final LottoNumber lottoNumber) {
        int number = lottoNumber.getNumber();
        return numbers.contains(number);
    }

    public boolean isContainsNumbersWithSize(final List<LottoNumber> goalNumbers, final int size) {
        List<Integer> lottoNumbers = new ArrayList<>(goalNumbers.stream()
                .map(LottoNumber::getNumber)
                .toList());

        lottoNumbers.retainAll(numbers);

        return lottoNumbers.size() == size;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
