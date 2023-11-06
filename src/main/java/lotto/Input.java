package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static List<Integer> winNumbers;

    public static int purchaseAmount() throws IllegalArgumentException {
        String amount = Console.readLine();

        Exception.notNumber(amount);
        Exception.notThousandWon(amount);

        return Integer.parseInt(amount);
    }

    public static List<Integer> winNumbers() {
        final int limitCount = 6;
        String[] numbers = Console.readLine().split(",");
        winNumbers = new ArrayList<>();

        for (String number : numbers) {
            Exception.notNumber(number);
            Exception.overLimitNumberRange(Integer.parseInt(number));
            winNumbers.add(Integer.parseInt(number));
        }

        Exception.overLimitCount(numbers.length, limitCount);
        Exception.duplicateWinNumbers(winNumbers);

        return winNumbers;
    }

    public static int bonusNumber() throws IllegalArgumentException {
        String bonus = Console.readLine();
        Exception.notNumber(bonus);

        int bonusNumber = Integer.parseInt(bonus);
        Exception.overLimitNumberRange(bonusNumber);
        Exception.duplicateBonusNumber(winNumbers, bonusNumber);

        return bonusNumber;
    }
}
