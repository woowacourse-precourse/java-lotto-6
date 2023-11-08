package lotto.view;

import static lotto.view.Output.consoleLine;

import java.util.Map;
import lotto.Message.GameMessage;

public class OutputResult {

    public static void printAllReultMessge(Map<Integer, Integer> resultLottos, double percentage){
        printStartMessage();
        printFirstMessage(resultLottos.get(3));
        printSecondMessage(resultLottos.get(4));
        printThirdMessage(resultLottos.get(5));
        printBonusMessage(resultLottos.get(6));
        printFourthMessage(resultLottos.get(7));
        printFifthMessage(percentage);
    }

    public static void printStartMessage () {
        System.out.println(GameMessage.OUT_RESULT_LOTTO_START_MESSAGE);
    }

    public static void printFirstMessage (int number){
        consoleLine(GameMessage.OUT_RESULT_CORRECT_THREE_MESSAGE + number + "개");
    }

    public static void printSecondMessage (int number){
        consoleLine(GameMessage.OUT_RESULT_CORRECT_FOUR_MESSAGE + number + "개");
    }

    public static void printThirdMessage (int number){
        consoleLine(GameMessage.OUT_RESULT_CORRECT_FIVE_MESSAGE + number + "개");
    }

    public static void printBonusMessage (int number){
        consoleLine(GameMessage.OUT_RESULT_CORRECT_BONUS_MESSAGE + number + "개");
    }

    public static void printFourthMessage (int number){
        consoleLine(GameMessage.OUT_RESULT_CORRECT_SIX_MESSAGE + number + "개");
    }

    public static void printFifthMessage (double percentage){
        consoleLine(GameMessage.OUT_RESULT_PERCENTAGE_MESSAGE + percentage + "%입니다.");
    }
}
