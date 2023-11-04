package lotto.view;

import static lotto.view.constans.constantMessage.PURCHASED_TICKET_COUNT;

import lotto.view.constans.constantMessage;

public class OutputView {

    public static void printConstantMessage(constantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static void responseCount(int count){
        System.out.print(count);
        printConstantMessage(PURCHASED_TICKET_COUNT);
    }


}