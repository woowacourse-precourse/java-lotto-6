package lotto.view;

import lotto.model.Lotto;
import lotto.model.collections.LottoBundle;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.Message.*;

public class OutputView {
    public static void printPurchaseAmountMessage(){
        printMessage(PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
    public static void printTicketCountMessage(int ticketCount){
        printMessage();
        printMessage(TICKET_COUNT_MESSAGE.formatMessage(ticketCount));
    }
    public static void printLottoBundle(LottoBundle lottoBundle){
        for(Lotto lotto: lottoBundle.getLottoBundle()){
            printMessage(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ","[","]"));
    }

    public static void printWinningNumbersMessage(){
        printMessage();
        printMessage(WINNING_NUMBERS_MESSAGE.getMessage());
    }
    public static void printBonusNumberMessage(){
        System.out.println(BONUS_NUMBER_MESSAGE.getMessage());
    }
    private static void printMessage(){
        System.out.println();
    }
    private static void printMessage(String message){
        System.out.println(message);
    }
}
