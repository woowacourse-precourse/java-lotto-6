package lotto.domain;

import lotto.util.LottoConstants;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
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
        if (checkNumbersCount(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNumbersCount(List<Integer> numbers) {
        return numbers.size() != LottoConstants.NUMBER_OF_LOTTO_NUMBERS.getValue();
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
