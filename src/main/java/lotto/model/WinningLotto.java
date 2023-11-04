package lotto.model;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    private WinningLotto(Lotto winningNumber, int bonusNumber){
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumber, int bonusNumber){
        return new WinningLotto(winningNumber, bonusNumber);
    }
}
