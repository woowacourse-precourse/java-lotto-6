package lotto.model;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.domain.Wallet;
import lotto.domain.WinRecord;

public class LottoModel {
    private Tickets tickets;
    private Wallet wallet;
    private Lotto lotto;
    private Bonus bonus;
    private WinRecord winRecord;

    public void saveTicktet(Tickets tickets) {
        this.tickets = tickets;
    }

    public void saveWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void saveLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void saveBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public void saveWinRecord(WinRecord winRecord) {
        this.winRecord = winRecord;
    }

    public Tickets findTickets() {
        return this.tickets;
    }

    public Lotto findLotto() {
        return this.lotto;
    }

    public Bonus findBonus() {
        return this.bonus;
    }

    public WinRecord findWinRecord() {
        return this.winRecord;
    }

    public Wallet findWallet() {
        return this.wallet;
    }
}
