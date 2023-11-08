package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = getPrice();
    }

    public static int getPrice() {
        OutputConsole.printMessage(OutputConsole.INPUT_PRICE_MESSAGE);
        return InputConsole.inputPrice();
    }

}
