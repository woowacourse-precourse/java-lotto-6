package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private final List<WinningNumber> winningNumbers;

    public WinningNumbers(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumbers(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        List<WinningNumber> winningNumbers = numbers.stream()
                .map(WinningNumber::new)
                .toList();
        return new WinningNumbers(winningNumbers);
    }

    private static void validateLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConfig.LOTTO_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplication(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if (set.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_MESSAGE);
        }
    }

    public boolean contains(Integer number) {
        return winningNumbers.stream().anyMatch(winningNumber -> winningNumber.is(number));
    }

    public boolean contains(BonusNumber bonusNumber) {
        return winningNumbers.stream().anyMatch(bonusNumber::is);
    }

}
