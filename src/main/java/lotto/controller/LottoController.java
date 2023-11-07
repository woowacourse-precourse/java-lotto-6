package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoSet;
import lotto.domain.Returns;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.domain.WinRecord;
import lotto.model.LottoModel;

public class LottoController {
    private LottoModel lottoModel;

    public LottoController(LottoModel lottoModel) {
        this.lottoModel = lottoModel;
    }

    public void gernerateTicket(final int money) {
        Ticket ticket = new Ticket(money);
        Tickets tickets = new Tickets(ticket);
        tickets.generate();

        lottoModel.saveTicktet(tickets);
    }

    public void inputLotto(final List<Integer> lottoNumbers, final int bonusNumber) {
        Lotto lotto = new Lotto(lottoNumbers);
        LottoSet lottoSet = new LottoSet(lotto, bonusNumber);

        lottoModel.saveLottoSet(lottoSet);
    }

    public void inputWinRecord() {
        Tickets tickets = lottoModel.findTickets();
        LottoSet lottoSet = lottoModel.findLottoSet();

        WinRecord winRecord = new WinRecord(lottoSet);
        winRecord.inputWinRecord(tickets);

        lottoModel.saveWinRecord(winRecord);
    }

    public void printWinRecord() {
        WinRecord winRecord = lottoModel.findWinRecord();
        winRecord.print();
    }

    public void printReturns(int money) {
        WinRecord winRecord = lottoModel.findWinRecord();

        Returns returns = new Returns(money);
        returns.calculate(winRecord);
        returns.print();
    }

}
