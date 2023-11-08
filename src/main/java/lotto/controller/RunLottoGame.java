package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicket;

import java.util.List;

public class RunLottoGame {
    private SetUserLotto userLotto;
    private SetLottoTicket setLottoTicket;
    LottoTicket lottoTicket = setLottoTicket.lottoTickets();

    public void gameIntro() {
        Printer.printPurchaseAmount();
        setLottoTicket.purchaseTicket();
        System.out.print(lottoTicket.getTickets());
        Printer.printTotalTickets();
    }

    public void Matching() {
        for(int i = 0 ; i < lottoTicket.getTickets(); i++){
            System.out.println("["+lottoTicket.getTicketNumbers().get(i) + "]");
        }

        System.out.println();
        Printer.printUserNumbers();
        userLotto.userLotto();
        System.out.println();

        Printer.printAskBonus();
        userLotto.bonusNumber();
        System.out.println();
    }

    public void endGame() {
        Printer.printResult();
        System.out.println("---");
    }
}