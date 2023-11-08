package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Prize;
import lotto.view.Statement;

public class RunLottoGame {
    private SetUserLotto userLotto;
    private SetLottoTicket setLottoTicket;
    private Calculation calculation;

    LottoTicket lottoTicket = setLottoTicket.lottoTickets();
    Lotto lotto = userLotto.userLotto();

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

    public void terminateGame(int[] counts, double rate) {
        counts = calculation.countMatchingNumbers(lotto, lottoTicket);
        int start = 0;
        Printer.printResult();
        System.out.println("---");

        for(Prize prize : Prize.values()) {
            if(!prize.getHasBonus()) {
                System.out.println(prize.getMatchingNumbers() + "개 일치, 보너스 볼 일치 (" + prize.getPrizeAmount() + "원) - " + counts[5] + "개");
            } else {
                System.out.println(prize.getMatchingNumbers() + "개 일치 (" + prize.getPrizeAmount() + "원) - " + counts[start] + "개");
            }
        }

        System.out.println(Statement.SHOW_PROFIT_RATE + calculation.calculateProfitRate(lotto,lottoTicket,userLotto) + "%입니다.");
    }

}