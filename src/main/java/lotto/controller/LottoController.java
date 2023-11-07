package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Returns;
import lotto.domain.Tickets;
import lotto.domain.Wallet;
import lotto.domain.WinRecord;
import lotto.model.LottoModel;

public class LottoController {
    private LottoModel lottoModel;

    public LottoController(LottoModel lottoModel) {
        this.lottoModel = lottoModel;
    }

    public void gernerateTicket(final int wallet) {
        Wallet wallets = new Wallet(wallet);
        Tickets tickets = new Tickets(wallets);

        tickets.generate();

        lottoModel.saveTicktet(tickets);
        lottoModel.saveWallet(wallets);
    }

    public void inputLotto(final List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);

        lottoModel.saveLotto(lotto);
    }

    public void inputBonus(final int number){
        Bonus bonus = new Bonus(number);

        lottoModel.saveBonus(bonus);
    }

    public void inputWinRecord() {
        Tickets tickets = lottoModel.findTickets();
        Lotto lotto = lottoModel.findLotto();
        Bonus bonus = lottoModel.findBonus();

        WinRecord winRecord = new WinRecord(lotto, bonus);
        winRecord.inputWinRecord(tickets);

        lottoModel.saveWinRecord(winRecord);
    }

    public void printWinRecord() {
        WinRecord winRecord = lottoModel.findWinRecord();
        winRecord.print();
    }

    public void printReturns() {
        WinRecord winRecord = lottoModel.findWinRecord();
        Wallet wallet = lottoModel.findWallet();

        Returns returns = new Returns(wallet, winRecord);
        returns.calculate();
        returns.print();
    }

}
