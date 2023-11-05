package lotto.domain;

import lotto.constant.Rank;

public class AnswerLotto {

    private final Lotto mainLotto;
    private final int bonusNumber;

    private AnswerLotto(final Lotto mainLotto, final int bonusNumber) {
        this.mainLotto = mainLotto;
        this.bonusNumber = bonusNumber;
    }

    public static AnswerLotto of(final Lotto mainLotto, final int bonusNumber) {
        mainLotto.validateBonusNumber(bonusNumber);

        return new AnswerLotto(mainLotto, bonusNumber);
    }

    public Rank getRank(final Lotto lotto) {
        final int sameNumberCount = mainLotto.countSameNumber(lotto);
        final boolean hasBonus = lotto.contains(bonusNumber);

        return Rank.of(sameNumberCount, hasBonus);
    }

}
