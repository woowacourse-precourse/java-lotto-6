package lotto.domain;

public class LottoWithBonus {
    private final Lotto userLotto;
    private final Bonus userBonus;

    private LottoWithBonus(Lotto lotto, Bonus bonus) {
        this.userLotto = lotto;
        this.userBonus = bonus;
    }

    public static LottoWithBonus of(Lotto lotto, Bonus bonus) {
        return new LottoWithBonus(lotto, bonus);
    }

    public int findSameNumberCount(Lotto generatedRandomLotto) {
        int sameLottoNumberCount = userLotto.findSameNumberCountInLotto(generatedRandomLotto);
        return sameLottoNumberCount;
    }

    public boolean isBonusInLotto(Lotto generatedRandomLotto) {
        return userBonus.hasSameNumberInGeneratedLotto(generatedRandomLotto);
    }
}
