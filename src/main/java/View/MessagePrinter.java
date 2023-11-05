package View;

import util.ProgressMessage;

public class MessagePrinter {
    static ProgressMessage inputAmount = ProgressMessage.INPUT_AMOUNT;

    public static void inputAmount(){
        System.out.println(inputAmount.getProgressMessage());
    }
}
