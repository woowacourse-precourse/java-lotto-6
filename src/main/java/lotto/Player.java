package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Constants.ErrorMessage;
import lotto.Constants.IntConstants;

public class Player {
    private final int bonusNumber;
    private final Lotto sixLottoNumber;

    public Player(Lotto sixLottoNumber, int bonusNumber) {
        validator();
        this.bonusNumber = bonusNumber;
        this.sixLottoNumber = sixLottoNumber;
    }

    public Lotto getSixNumbers() {
        return sixLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validator() {
        isProperRange(bonusNumber);
        isProperRange(sixLottoNumber.getNumbers());
        isDuplicated(bonusNumber, sixLottoNumber.getNumbers());
        isDuplicated(sixLottoNumber.getNumbers());
    }

    private void isProperRange(int number) {
        if (number < IntConstants.MIN_RANGE.getValue()
                || number > IntConstants.MAX_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    private void isProperRange(List<Integer> sixNumbers) {
        for (Integer sixNumber : sixNumbers) {
            if (sixNumber < IntConstants.MIN_RANGE.getValue()
                    || sixNumber > IntConstants.MAX_RANGE.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
            }
        }
    }

    private void isDuplicated(List<Integer> sixNumbers) {
        Set<Integer> integerSet = new HashSet<>(sixNumbers);
        if (integerSet.size() != IntConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }

    private void isDuplicated(int number, List<Integer> sixNumbers) {
        if (sixNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLIDATED_BOUNS_MESSAGE.getMessage());
        }
    }
}
