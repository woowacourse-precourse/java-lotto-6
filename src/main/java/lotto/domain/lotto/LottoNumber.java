package lotto.domain.lotto;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        boolean isOverValue = number > LottoConfig.MAX_NUMBER.getValue();
        boolean isUnderValue = number < LottoConfig.MIN_NUMBER.getValue();
        if (isOverValue || isUnderValue) {
            throw new IllegalArgumentException(LottoExceptionMessages.INVALID_NUMBER_RANGE.getMessage());
        }
    }

}
