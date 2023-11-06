package lotto.domain;

public class LottoWinning {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoWinning(Lotto winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
