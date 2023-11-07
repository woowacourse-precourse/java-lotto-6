package lotto.model;

import lotto.domain.Lotto;
import lotto.domain.LottoSet;
import lotto.domain.Tickets;
import lotto.domain.WinRecord;

public class LottoModel {
    private LottoSet lottoSet;
    private Tickets tickets;
    private WinRecord winRecord;

    public void saveTicktet(Tickets tickets) {
        this.tickets = tickets;
    }

    public void saveWinRecord(WinRecord winRecord) {
        this.winRecord = winRecord;
    }

    public void saveLottoSet(LottoSet lottoSet) {
        this.lottoSet = lottoSet;
    }

    public Tickets findTickets() {
        return this.tickets;
    }

    public WinRecord findWinRecord() {
        return this.winRecord;
    }

    public LottoSet findLottoSet() {
        return this.lottoSet;
    }
}
