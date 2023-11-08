package lotto.domain;

import static lotto.constant.ExceptionMessage.LOTTO_LENGTH_ERROR_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.utils.validator.LottoNumberValidator.validateDuplicateNumbers;
import static lotto.utils.validator.LottoNumberValidator.validateOutOfRange;

import java.util.List;

public class WinningNumber implements Containable {

    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validateLottoLength(winningNumber);
        validateOutOfRange(winningNumber);
        validateDuplicateNumbers(winningNumber);
        this.winningNumber = winningNumber;
    }

    public int calculateCorrectNumberCount(Lotto lotto) {
        int count = 0;
        for (int number : winningNumber) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(int number) {
        return winningNumber.contains(number);
    }

    private void validateLottoLength(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }
}
