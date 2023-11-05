package View;

import util.ProgressMessage;

public class MessagePrinter {
    static ProgressMessage inputPrice = ProgressMessage.INPUT_PRICE;

    public static void inputPrice(){
        System.out.println(inputPrice.getProgressMessage());
    }
}
