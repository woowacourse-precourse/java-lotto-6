package lotto.lotto;

import static lotto.lotto.LottoValidator.*;

import java.util.List;
import lotto.message.ErrorMessage;

public class WinningNumber {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateNumbers(winningNumbers);
        validateNumber(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUM_DUPLICATE);
        }
    }

    public Long countMatchingNumber(Lotto lotto) {
        Long count = winningNumbers.stream()
                .filter(lotto::contains)
                .count();
        return count;
    }

    public boolean checkBonusNumberMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

}
