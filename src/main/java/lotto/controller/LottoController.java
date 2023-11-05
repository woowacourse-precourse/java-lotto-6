package lotto.controller;

import static lotto.ApplicationContext.getDataModel;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Returns;
import lotto.domain.Tickets;
import lotto.domain.WinRecord;
import lotto.model.DataModel;

public class LottoController {
    private DataModel dataModel = getDataModel();

    public void gernerateTicket(final int wallet) {
        Tickets tickets = new Tickets(wallet);
        tickets.generate();
        tickets.saveTickets();
        tickets.saveWallet();
    }

    public void inputLotto(final List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lotto.save();
    }

    public void inputBonus(final int number){
        Bonus bonus = new Bonus(number);
        bonus.save();
    }

    public void compareWinning() {
        List<List<Integer>> tickets = dataModel.findTickets();
        List<Integer> lotto = dataModel.findLotto();
        int bonus = dataModel.findBonus();

        WinRecord winRecord = new WinRecord(lotto, bonus);
        winRecord.compareWinning(tickets);
        winRecord.save();
    }

    public void printWinRecord() {
        List<Integer> winRecord = dataModel.findWinRecord();

        WinRecord.print(winRecord);
    }

    public void printReturns() {
        List<Integer> winRecord = dataModel.findWinRecord();
        int wallet = dataModel.findWallet();

        Returns returns = new Returns(wallet, winRecord);
        returns.calculate();
        returns.print();
    }

}
