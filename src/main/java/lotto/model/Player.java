package lotto.model;

public class Player {
    private Lotto lotto;

    private Money capital;

    public Player(Lotto lotto, Money capital) {
        this.lotto = lotto;
        this.capital = capital;
    }
}
