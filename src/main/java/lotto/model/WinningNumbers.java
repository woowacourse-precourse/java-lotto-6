package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.LottoNumberValidator;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;

    private WinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumbers(List<Integer> numbers) {
        LottoNumberValidator.validateNumbers(numbers);
        Set<Integer> reformedNumbers = new HashSet<>(numbers);
        return new WinningNumbers(reformedNumbers);
    }

    public void validateDuplicateNumber(Integer number) {
        if (hasNumber(number)) {
            throw new IllegalArgumentException("중복된 숫자입니다.");
        }
    }

    public boolean hasNumber(Integer number) {
        return this.winningNumbers.contains(number);
    }
}
