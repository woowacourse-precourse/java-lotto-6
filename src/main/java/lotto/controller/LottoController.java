package lotto.controller;

import static lotto.ApplicationContext.getDataModel;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Returns;
import lotto.domain.Tickets;
import lotto.domain.Wallet;
import lotto.domain.WinRecord;
import lotto.model.DataModel;

public class LottoController {
    private DataModel dataModel = getDataModel();

    public void gernerateTicket(final int wallet) {
        Wallet wallets = new Wallet(wallet);
        Tickets tickets = new Tickets(wallets);

        tickets.generate();
        tickets.save();
        wallets.save();
    }

    public void inputLotto(final List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lotto.save();
    }

    public void inputBonus(final int number){
        Bonus bonus = new Bonus(number);
        bonus.save();
    }

    public void inputWinRecord() {
        Tickets tickets = dataModel.findTickets();
        Lotto lotto = dataModel.findLotto();
        Bonus bonus = dataModel.findBonus();

        WinRecord winRecord = new WinRecord(lotto, bonus);
        winRecord.inputWinRecord(tickets);
        winRecord.save();
    }

    public void printWinRecord() {
        WinRecord winRecord = dataModel.findWinRecord();
        winRecord.print();
    }

    public void printReturns() {
        WinRecord winRecord = dataModel.findWinRecord();
        Wallet wallet = dataModel.findWallet();

        Returns returns = new Returns(wallet, winRecord);
        returns.calculate();
        returns.print();
    }

}
