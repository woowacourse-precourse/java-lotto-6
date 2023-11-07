package lotto.model;

import lotto.Lotto;

public class User {
    private static int paymentAmount;
    private static Lotto winningNumber;
    private static int manyLottoTicket;
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

    public int getManyLottoTicket() {
        return manyLottoTicket;
    }

    public void setManyLottoTicket(int manyLottoTicket) {
        User.manyLottoTicket = manyLottoTicket;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        User.bonusNumber = bonusNumber;
    }
}
