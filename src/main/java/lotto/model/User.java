package lotto.model;

import lotto.utils.StringConvertor;

public class User {

    private int bonus;
    private Lotto userLotto;

    public User(Lotto userLotto, String bonusInput) {
        this.bonus = StringConvertor.stringToInt(bonusInput);
        this.userLotto = userLotto;
    }

    public Rank getRank(Lotto lotto) {
        int matchingNumber = userLotto.countMatchingNumber(lotto);
        boolean isBonusContain = userLotto.isContain(bonus);

        return Rank.findRank(matchingNumber, isBonusContain);
    }

}
