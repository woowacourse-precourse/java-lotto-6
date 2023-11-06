package lotto.model;

public class ResultLotto {

    private final Lotto winningLotto;
    private final int bonusNum;

    public ResultLotto(Lotto winningLotto, int bonusNum) {
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }
}
