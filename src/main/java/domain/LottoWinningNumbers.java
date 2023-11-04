package domain;

import exception.DuplicateNumberException;
import java.util.List;

public class LottoWinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private LottoWinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumbers createWinningNumbers(List<Integer> numbers, int bonusNumber) {
        validateDuplicateBonusNumber(numbers, bonusNumber);
        return new LottoWinningNumbers(new Lotto(numbers), new LottoNumber(bonusNumber));
    }

    private static void validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new DuplicateNumberException();
        }
    }
}
