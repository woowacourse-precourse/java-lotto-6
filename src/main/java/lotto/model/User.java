package lotto.model;

import lotto.utils.StringConvertor;

public class User {

    private final int bonus;
    private final Lotto userLotto;

    public User(Lotto userLotto, String bonusInput) {
        userLotto.validateBonusNumber(bonusInput);
        this.bonus = StringConvertor.stringToInt(bonusInput);
        this.userLotto = userLotto;
    }

    public Rank getRank(Lotto lotto) {
        int matchingNumber = userLotto.countMatchingNumber(lotto);
        boolean isBonusContain = lotto.isContain(bonus);

        return Rank.findRank(matchingNumber, isBonusContain);
    }

}
