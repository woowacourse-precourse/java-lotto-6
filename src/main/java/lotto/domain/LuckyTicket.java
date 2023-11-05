package lotto.domain;

import lotto.Lotto;

public class LuckyTicket {

    private final Lotto lotto;
    private final int bonusNumber;

    private LuckyTicket(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LuckyTicket of(Lotto lotto, int bonusNumber) {
        return new LuckyTicket(lotto, bonusNumber);
    }
}
