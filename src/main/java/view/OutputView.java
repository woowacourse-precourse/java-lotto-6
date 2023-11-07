package view;

import constants.message.RequestMessage;
import constants.message.StatisticsMessage;

public class OutputView {
    public void requestPayment(){
        System.out.println(RequestMessage.PAYMENT);
    }

    public void requestWinningNumbers(){
        System.out.println(RequestMessage.WINNING_NUMBERS);
    }

    public void requestBonusNumber(){
        System.out.println(RequestMessage.BONUS_NUMBER);
    }

    public void printStatisticsStart(){
        System.out.println(StatisticsMessage.START);
    }

    public void printStatisticsStartLine(){
        System.out.println(StatisticsMessage.START_LINE);
    }

    public void printFormattedLine(String formattedContent){
        System.out.println(formattedContent);
    }
}