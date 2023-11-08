package lotto.domain.lotto;

public record LottoNumber(int number) {

    public LottoNumber {
        validateRange(number);
    }

    private void validateRange(int number) {
        boolean isOverValue = number > LottoConfig.MAX_NUMBER.getValue();
        boolean isUnderValue = number < LottoConfig.MIN_NUMBER.getValue();
        if (isOverValue || isUnderValue) {
            throw new IllegalArgumentException(LottoExceptionMessages.INVALID_NUMBER_RANGE.getMessage());
        }
    }

}
