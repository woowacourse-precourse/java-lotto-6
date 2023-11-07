package lotto.domain;

public class LottoBonus {
    private final int number;

    public LottoBonus(Lotto winningLotto, String number) {
        this.number = convertToInteger(number.strip());
        validate(winningLotto, this.number);
    }

    public int getNumber() {
        return number;
    }

    private int convertToInteger(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NOT_INTEGER.getMessage());
        }
    }

    private void validate(final Lotto winningLotto, final int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        } else if (winningLotto.contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_LOTTO_CONTAINS_BONUS.getMessage());
        }
    }

    private boolean isInRange(final int number) {
        return (number >= LottoInfo.RANGE_BEGIN.getNumber()) && (number <= LottoInfo.RANGE_END.getNumber());
    }
}
