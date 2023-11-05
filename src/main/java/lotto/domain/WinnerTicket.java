package lotto.domain;

import lotto.Lotto;

public class WinnerTicket {

    private final Lotto lotto;
    private final int bonusNumber;

    private WinnerTicket(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerTicket of(Lotto lotto, int bonusNumber) {
        return new WinnerTicket(lotto, bonusNumber);
    }
}
