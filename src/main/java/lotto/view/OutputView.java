package lotto.view;

import lotto.util.Message;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printLottoStartMessage() {
        printMessage(Message.START_LOTTO_MESSAGE);
    }
    public static void printInputDangchumMessage() {
        printMessage(Message.INPUT_DANGCHUM_NUM_MESSAGE);
    }
    public static void printInputBonusMessage() {
        printMessage(Message.INPUT_BONUS_NUM_MESSAGE);
    }


}
