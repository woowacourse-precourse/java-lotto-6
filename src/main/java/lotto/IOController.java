package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IOController {
    private int price;

    public IOController() {
        inputPrice();
    }

    private void inputPrice() {
        price = Integer.parseInt(Console.readLine());
    }
}
