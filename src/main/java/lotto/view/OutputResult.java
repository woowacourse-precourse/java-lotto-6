package lotto.view;

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

//    public static void printAllReultZeroMessge(Map<Integer, Integer> resultLottos, long percentage){
//        printStartMessage();
//        printFirstMessage(0);
//        printSecondMessage(0);
//        printThirdMessage(0);
//        printBonusMessage(0);
//        printFourthMessage(0);
//        printFifthMessage(0);
//    }

    public static void printStartMessage () {
        System.out.println(GameMessage.OUT_RESULT_LOTTO_START_MESSAGE);
    }

    public static void printFirstMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_THREE_MESSAGE + number + "개");
    }

    public static void printSecondMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_FOUR_MESSAGE + number + "개");
    }

    public static void printThirdMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_FIVE_MESSAGE + number + "개");
    }

    public static void printBonusMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_BONUS_MESSAGE + number + "개");
    }

    public static void printFourthMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_SIX_MESSAGE + number + "개");
    }

    public static void printFifthMessage (double percentage){
        System.out.println(GameMessage.OUT_RESULT_PERCENTAGE_MESSAGE + percentage + "%입니다.");
    }
}
