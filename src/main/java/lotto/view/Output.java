package lotto.view;

import static lotto.message.OutputMessage.*;

public class Output {
    public static void printWinningStatisticsMessage(){
        System.out.println(WINNING_STATISTICS.outputMessage());
        System.out.println(SEPARATOR.outputMessage());
    }
}
