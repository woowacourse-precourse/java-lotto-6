package lotto;

public record BonusNumber(int bonusNumber) {

    public static BonusNumber from(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (NumberUtils.isNotInRange(Lotto.START_INCLUSIVE, Lotto.END_INCLUSIVE, bonusNumber)) {
            throw new IllegalArgumentException(Lotto.LOTTO_RANGE_EXCEPTION);
        }
    }
}
