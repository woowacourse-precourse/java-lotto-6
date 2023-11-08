package lotto.domain.entity;

public class WinningTicket {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;


    private WinningTicket(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningTicket create(Lotto winningNumbers, LottoNumber bonusNumber) {
        return new WinningTicket(winningNumbers, bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
