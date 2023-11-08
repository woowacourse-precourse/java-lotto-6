package lotto.view;

import lotto.constant.OutputMessage;
import lotto.domain.LottoCounter;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;

public class OutputView {

    public void printPurchaseMessage() {
        System.out.println(OutputMessage.PURCHASE_AMOUNT.getMessage());
    }

    public void printTicketCount(LottoCounter lottoCounter) {
        String message = OutputMessage.LOTTO_TICKET_COUNT.getMessage();
        System.out.printf(message, lottoCounter.getTicketCount());
        System.out.println();
    }

    public void printLottoesNumber(Lottoes lottoes) {
        System.out.println(lottoes.getLottoesNumber());
    }

    public void printWinningNumberMessage() {
        System.out.println(OutputMessage.READ_WINNING_NUMBER.getMessage());
    }

    public void printBonusNumber() {
        System.out.println(OutputMessage.READ_BONUS_NUMBER.getMessage());
    }

    public void printResult(LottoResult result) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getMessage());
        System.out.println(OutputMessage.LINE.getMessage());
        System.out.print(result.getResultScreen());
    }

    public void printProfit(double profit) {
        System.out.printf(OutputMessage.PROFIT.getMessage(), profit);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}