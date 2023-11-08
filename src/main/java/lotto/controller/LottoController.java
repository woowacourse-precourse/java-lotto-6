package lotto.controller;public class LottoController {
    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = validateBonus();

        lottoResult(lottoList, winningResult, ticketCount);

    }
}
