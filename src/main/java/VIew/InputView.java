package VIew;

import Interface.MessagePrinter;

public class InputView implements MessagePrinter {
    public void printMessage(String message) {
        System.out.println(message);
    }

}
