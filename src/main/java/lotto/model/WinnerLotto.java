package lotto.model;

public class WinnerLotto {
    Lotto WinnerLotto;
    int bonus;

    public WinnerLotto(Lotto winnerLotto,int bonus){
        this.WinnerLotto = winnerLotto;
        this.bonus = bonus;
    }
}
