package lotto.model;

public class BonusNumber {

    private final LottoNumber number;

    private BonusNumber(final int bonusNumber) {
        this.number = LottoNumber.of(bonusNumber);
    }

    public static BonusNumber of(final int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public BonusStatus existOn(final Lotto lotto) {
        if (lotto.contains(number)) {
            return BonusStatus.INCLUDED;
        }
        return BonusStatus.NONE;
    }
}
