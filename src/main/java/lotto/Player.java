package lotto;

import java.util.List;

public class Player {
    private final int bonusNumber;
    private final Lotto sixLottoNumber;

    public Player(Lotto sixLottoNumber, int bonusNumber) {
        isProperRange(bonusNumber);
        isDuplicated(bonusNumber, sixLottoNumber.getNumbers());
        this.bonusNumber = bonusNumber;
        this.sixLottoNumber = sixLottoNumber;
    }

    public Lotto getSixNumbers() {
        return sixLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isProperRange(int number) {
        if (number < IntConstants.MIN_RANGE.getValue()
                || number > IntConstants.MAX_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    private void isDuplicated(int number, List<Integer> sixNumbers) {
        if (sixNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
