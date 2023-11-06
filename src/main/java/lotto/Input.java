package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int getAmount() {
        String input = Console.readLine();
        int amount = Integer.parseInt(input);

        if (!validAmount(amount)) {
            throw new IllegalArgumentException();
        }
        return amount;
    }

    private static boolean validAmount(int amount) {
        return (amount % 1000) == 0;
    }
}
