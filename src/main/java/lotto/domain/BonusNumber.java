package lotto.domain;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int number) {
        validateNumberRange(number);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void validateNumberRange(int number) {

        boolean isValidRange = (number >= LottoNumberRange.MIN.getValue() && number <= LottoNumberRange.MAX.getValue());

        if (!isValidRange) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_NUMBER_RANGE.getValue()
            );
        }
    }

}
