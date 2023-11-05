package lotto.domain;

public record LottoDraw(Lotto winningLotto , int bonusNumber) {
    public LottoDraw(Lotto winningLotto , int bonusNumber){
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}