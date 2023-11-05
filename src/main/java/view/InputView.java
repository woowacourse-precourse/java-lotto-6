package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputPrice() {
        String price = Console.readLine();
        return Integer.parseInt(price);
    }
}
