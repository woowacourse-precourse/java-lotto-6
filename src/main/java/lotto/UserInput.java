package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public UserInput() {

    }

    public int priceInput() {
        String price = Console.readLine();

        return Integer.parseInt(price);
    }
}
