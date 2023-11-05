package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Returns;
import lotto.domain.Tickets;
import lotto.domain.WinRecord;

public class LottoController {
    private Tickets tickets;
    private Lotto lotto;
    private Bonus bonus;
    private WinRecord winRecord;

    public void gernerateTicket(final int wallet) {
        this.tickets = new Tickets(wallet);
        this.tickets.generate();
    }

    public void inputLotto(final List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public void inputBonus(final int number){
        this.bonus = new Bonus(number);
    }

    public void compareWinning() {
        List<List<Integer>> tickets = this.tickets.getTickets();
        List<Integer> lotto = this.lotto.getNumbers();
        int bonus = this.bonus.getNumber();

        this.winRecord = new WinRecord(lotto, bonus);
        this.winRecord.compareWinning(tickets);
    }

    public void printWinRecord() {
        this.winRecord.print();
    }

    public void printReturns() {
        List<Integer> winRecord = this.winRecord.getWinRecord();
        int wallet = this.tickets.getWallet();

        Returns returns = new Returns(wallet, winRecord);
        returns.print();
    }

}
