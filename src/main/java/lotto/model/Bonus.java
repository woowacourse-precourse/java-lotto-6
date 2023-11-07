package lotto.model;

public class Bonus {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public boolean countSameNumber(Lotto lotto) {
        return lotto.isContains(number);
    }

    private void validate(int number) {
        validateNumberRange(number);
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            Error.NOT_VALID_BONUS_NUMBER_RANGE.throwError();
        }
    }
}
