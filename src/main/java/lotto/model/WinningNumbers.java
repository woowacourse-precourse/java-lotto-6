package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.utils.LottoNumberValidator;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;

    private WinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumbers(List<Integer> numbers) {
        validateLength(numbers);
        WinningNumbers winningNumbers = new WinningNumbers(new HashSet<>());
        numbers.forEach(winningNumbers::addNumber);
        return winningNumbers;
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }

    public void validateDuplicateNumber(Integer number) {
        if (hasNumber(number)) {
            throw new IllegalArgumentException("중복된 숫자입니다.");
        }
    }

    private void addNumber(Integer number) {
        LottoNumberValidator.validate(number);
        validateDuplicateNumber(number);
        this.winningNumbers.add(number);
    }

    public boolean hasNumber(Integer number) {
        return this.winningNumbers.contains(number);
    }
}
