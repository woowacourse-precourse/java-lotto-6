package lotto.Exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Lotto.END_NUMBER;
import static lotto.Lotto.START_NUMBER;

public class Exception {
    public static boolean isValidMoney(int money) {
        return money >= 1000 && money % 1000 == 0;
    }

    public static boolean isValidWinningNumbers(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }

    public static boolean isValidWinningNumberSingle(String[] splitNumbers) {

        for (int i = 0; i < splitNumbers.length; i++) {
            if (Integer.parseInt(splitNumbers[i]) < START_NUMBER || Integer.parseInt(splitNumbers[i]) > END_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNoneEqualNumbers(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer element : winningNumbers) {
            if (!set.add(element)) {
                return false;
            }
        }
        return true;
    }

}
