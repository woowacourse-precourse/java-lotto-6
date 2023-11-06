package lotto;

import java.util.List;
import lotto.Constants.ErrorMessage;
import lotto.Constants.IntConstants;

public class Player {
    private final int bonusNumber;
    private final Lotto sixLottoNumber;

    public Player(Lotto sixLottoNumber, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.sixLottoNumber = sixLottoNumber;
        validator();
    }

    public Lotto getSixNumbers() {
        return sixLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validator() {
        isProperRange(bonusNumber);
        isDuplicated(bonusNumber, sixLottoNumber.getNumbers());
    }

    private void isProperRange(int number) {
        if (number < IntConstants.MIN_RANGE.getValue()
                || number > IntConstants.MAX_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    private void isDuplicated(int number, List<Integer> sixNumbers) {
        if (sixNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLIDATED_BOUNS_MESSAGE.getMessage());
        }
    }
}
