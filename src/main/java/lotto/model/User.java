package lotto.model;

import lotto.Lotto;

public class User {
    private static int paymentAmount;
    private static Lotto winningNumber;
    private static int lottoTicketCount;
    private static int bonusNumber;

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        User.paymentAmount = paymentAmount;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(Lotto winningNumber) {
        User.winningNumber = winningNumber;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public void setLottoTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        User.bonusNumber = bonusNumber;
    }
}
