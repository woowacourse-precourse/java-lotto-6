package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        boolean hasBonus = userLotto.getLottoNumbers().contains(bonus);
        userLotto.getLottoNumbers().retainAll(lotto.getLottoNumbers());

        return Rank.getRank(userLotto.getLottoNumbers().size(), hasBonus);
    }
}
