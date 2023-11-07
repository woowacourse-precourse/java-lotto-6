package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;
import lotto.util.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoNumbers(new ArrayList<>(numbers));
    }

    public Integer getMatchingNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        Integer matchingNumbers = calculateMatchingNumberWithWinningNumbers(winningNumbers);

        if (isMatchingWithBonusNumber(bonusNumber)) {
            matchingNumbers += 1;
        }

        return matchingNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private Integer calculateMatchingNumberWithWinningNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isMatchingWithBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (checkNumbersCount(numbers)) {
            throw new LottoGameException(ErrorMessage.INVALID_INTEGER_COUNT);
        }
        if (hasDuplicates(numbers)) {
            throw new LottoGameException(ErrorMessage.DUPLICATE_INPUT);
        }
        if (hasOutOfRangeNumbers(numbers)) {
            throw new LottoGameException(ErrorMessage.OUT_OF_RANGE);
        }
    }
    
    private boolean checkNumbersCount(List<Integer> numbers) {
        return numbers.size() != LottoConstants.NUMBER_OF_LOTTO_NUMBERS.getValue();
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasOutOfRangeNumbers(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue());
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
