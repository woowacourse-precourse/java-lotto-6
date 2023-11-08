package lotto.Message;

import java.util.Map;

public class ResultMessage {

    public static void printAllReultMessge(Map<Integer, Integer> resultLottos){
        startMessage();
        firstMessage(resultLottos.get(0));
        secondMessage(resultLottos.get(1));
        thirdMessage(resultLottos.get(2));
        bonusMessage(resultLottos.get(3));
        fourthMessage(resultLottos.get(4));
    }

    public static void startMessage () {
        System.out.println(GameMessage.OUT_RESULT_LOTTO_START_MESSAGE);
    }

    public static void firstMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_THREE_MESSAGE + number + "개");
    }

    public static void secondMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_FOUR_MESSAGE + number + "개");
    }

    public static void thirdMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_FIVE_MESSAGE + number + "개");
    }

    public static void bonusMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_BONUS_MESSAGE + number + "개");
    }

    public static void fourthMessage (int number){
        System.out.println(GameMessage.OUT_RESULT_CORRECT_SIX_MESSAGE + number + "개");
    }
}
