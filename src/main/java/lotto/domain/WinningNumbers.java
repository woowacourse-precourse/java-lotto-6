package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.SizeNotEqualException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private final Set<LottoNumber> winningNumbers;

    private WinningNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicate(numbers);
        this.winningNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static WinningNumbers createWinningNumbers(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new SizeNotEqualException(WINNING_NUMBERS_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new DuplicateNumberException();
        }
    }

    public boolean contains(LottoNumber number) {
        return winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber.equals(number));
    }


    public int calculateMatchCount(Lotto lotto) {
        HashSet<LottoNumber> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
        lottoNumbers.retainAll(winningNumbers);
        return lottoNumbers.size();
    }
}
