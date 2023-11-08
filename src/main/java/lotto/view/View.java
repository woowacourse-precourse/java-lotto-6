package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.model.constants.StringConstants.NEW_LINE;
import static lotto.view.constants.OutputMessage.*;

public class View {

    public void printMessage(String outputMessage){
        System.out.println(outputMessage);
    }

    public String askPurchasingAmount(){
        printMessage(ASK_PURCHASING_AMOUNT.getMessage());
        return Console.readLine();
    }

    public void printOrderedLottoCount(int ticketCount) {
        printMessage(NEW_LINE.get() + ticketCount + COUNT_BUYING_TICKETS.getMessage());
    }

    public void printLottoTickets(String tickets){
        printMessage(tickets);
    }

    public String askWinningNumbers(){
        printMessage(ASK_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String askBonusNumber(){
        printMessage(ASK_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }

    public void printStatistics(String result){
        printMessage(STATISTICS.getMessage() + result);
    }

    public void printProfit(String profit) {
        printMessage(PROFIT_START.getMessage() + profit + PROFIT_END.getMessage());
    }
}
