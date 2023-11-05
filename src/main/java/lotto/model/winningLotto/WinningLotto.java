package lotto.model.winningLotto;


import lotto.model.lotto.Lotto;

public class WinningLotto {
    protected final Lotto winningNumber;
    protected final int bonusNumber;

    private WinningLotto(Lotto winningNumber, int bonusNumber){
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumber, int bonusNumber){
        return new WinningLotto(winningNumber, bonusNumber);
    }

    public WinningLottoDTO toWinningLottoDTO(){
        return WinningLottoDTO.of(WinningLotto.of(winningNumber, bonusNumber));
    }
}
