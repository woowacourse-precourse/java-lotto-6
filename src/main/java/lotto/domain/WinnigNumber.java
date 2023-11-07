package lotto.domain;

public class WinnigNumber {
    private final Lotto lotto;
    private final int bonus;

    private WinnigNumber(final Lotto lotto, final int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinnigNumber of(final Lotto lotto, final int bonus) {
        return new WinnigNumber(lotto, bonus);
    }

    public int getBonus() {
        return bonus;
    }

//    private static void validate(final Lotto lotto, final LottoNumber bonus) {
//        if (lotto.contains(bonus)) {
//            throw new BonusNumDuplicatedException();
//        }
//    }
//
//    public boolean contains(final LottoNumber number) {
//        return lotto.contains(number);
//    }
}
