package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateUniqueNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_IS_SMALL);
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoConstants.LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_IS_DUPLICATED);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_IS_NOT_VALID_RANGE);
            }
        }
    }

    public Rank matchRank(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = calculateMatchCount(winningNumbers);
        boolean matchBonus = containsBonusNumber(bonusNumber);
        return Rank.determineRank(matchCount, matchBonus);
    }

    private int calculateMatchCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::isContained)
                .count();
    }

    private boolean containsBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isContainedIn(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
