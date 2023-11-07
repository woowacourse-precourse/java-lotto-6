package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.constants.OutputMessage.*;

public class View {

    private void printMessage(String outputMessage){
        System.out.println(outputMessage);
    }

    public String askPurchasingAmount(){
        printMessage(ASK_PURCHASING_AMOUNT.getMessage());
        return Console.readLine();
    }

    public void printOrderedLottoCount(int ticketCount) {
        printMessage("\n" + ticketCount + COUNT_BUYING_TICKETS.getMessage());
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

    public void printProfit(double profit) {
        printMessage(PROFIT_START.getMessage() + profit + PROFIT_END.getMessage());
    }
}
