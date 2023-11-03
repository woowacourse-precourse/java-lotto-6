package lotto;

public class Player {
    private final int bonusNumber;
    private final Lotto sixLottoNumber;

    public Player(Lotto sixLottoNumber, int bonusNumber) {
        isProperRange(bonusNumber);
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
}
