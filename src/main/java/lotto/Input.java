package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static List<Integer> winNumbers;

    public static int purchaseAmount() throws IllegalArgumentException {
        String amount = Console.readLine();
        Exception.notNumber(amount);

        int purchaseAmount = Integer.parseInt(amount);
        Exception.notThousandWon(purchaseAmount);

        return purchaseAmount;
    }

    public static List<Integer> winNumbers() {
        String[] numbers = Console.readLine().split(",");
        winNumbers = new ArrayList<>();
        
        for (String number : numbers) {
            Exception.notNumber(number);

            int winNumber = Integer.parseInt(number);
            Exception.overLimitNumberRange(winNumber);
            winNumbers.add(winNumber);
        }
        Exception.overLimitCount(winNumbers.size());
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
