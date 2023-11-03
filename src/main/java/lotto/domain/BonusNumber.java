package lotto.domain;

public class BonusNumber {
    public static final String INVALID_LOTTO_NUMBER_RANGE_MESSAGE =
            "보너스 번호를 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 사이의 숫자로 입력해주세요.";
    private final int number;

    public BonusNumber(int number) {
        validateBonusNumber(number);
        this.number = number;
    }

    private void validateBonusNumber(final int number) {
        validateNumbersInLottoRange(number);
    }

    private void validateNumbersInLottoRange(final int number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }
}
