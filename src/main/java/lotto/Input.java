package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static int purchaseAmount() throws IllegalArgumentException {
        int amount = 0;

        try {
            amount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        return amount;
    }

    public static List<Integer> winNumbers() {
        String[] numbers = Console.readLine().split(",");
        List<Integer> winNumbers = new ArrayList<>();

        for (String number : numbers) {
            winNumbers.add(Integer.parseInt(number));
        }

        return winNumbers;
    }

    public static int bonusNumber() throws IllegalArgumentException {
        int bonus = 0;

        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        return bonus;
    }
}
