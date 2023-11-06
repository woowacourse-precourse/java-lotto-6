package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPaper;

import java.util.List;

public class OutputView {
    private static void printMessage(String message){
        System.out.println(message);
    }
    public static void printPaymentMessage(){
        printMessage(OutputViewMessage.PAYMENT.getMessage());
    }
    public static void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
    public static void printWinningDrawMessage(){
        printMessage(OutputViewMessage.WINNING_DRAW.getFormattedMessage());
    }
    public static void printBonusDrawMessage(){
        printMessage(OutputViewMessage.BONUS_DRAW.getFormattedMessage());
    }
    public static void printLottoPaperMessage(LottoPaper lottoPaper){
        int ticketCount = lottoPaper.lottoTickets().size();
        List<Lotto> lottoTickets = lottoPaper.lottoTickets();
        printMessage(OutputViewMessage.PURCHASED_TICKETS_COUNT.getFormattedMessage(ticketCount));
        for (Lotto lotto : lottoTickets){
            printMessage(lotto.getNumbers().toString());
        }
    }
}
