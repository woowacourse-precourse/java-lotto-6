package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final Bonus bonus;

    private WinningLotto(Lotto lotto, Bonus bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(Lotto lotto, Bonus bonus){
        return new WinningLotto(lotto, bonus);
    }
}
