package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmount implements UserInput {
    public static int lottoQuantity;

    public void read() {
        lottoQuantity = singleTypeConversion(userInput());
    }

    public String userInput() {
        return Console.readLine();
    }

    public int singleTypeConversion(String money) {
        return Integer.parseInt(money) / 1000;
    }

}
