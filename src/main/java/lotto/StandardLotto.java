package lotto;

public class StandardLotto {
    private final Lotto userLotto;
    private final Integer bonusNumber;

    public StandardLotto(Lotto userLotto, Integer bonusNumber) {
        this.userLotto = userLotto;
        this.bonusNumber = bonusNumber;
    }

    public Prize matchPrize(Lotto lotto){
        long compareCount = userLotto.compare(lotto);
        boolean containsBonusNumber = lotto.containsBonusNumber(bonusNumber);
        return Prize.getByCountAndBonus(compareCount, containsBonusNumber);
    }
}