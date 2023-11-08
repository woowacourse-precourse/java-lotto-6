package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Exception {
    public static boolean isValidMoney(int money){
        return money >= 1000 && money % 1000 == 0;
    }

    public static boolean isValidWinningNumbers(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }

    public static boolean isValidWinningNumberSingle(String[] splitNumbers) {
        HashSet<String> hm = new HashSet<>();
        for (int i = 0; i < splitNumbers.length; i++) {
            if (Integer.parseInt(splitNumbers[i]) < 1 || Integer.parseInt(splitNumbers[i])>45){
                return false;
            }
            hm.add(splitNumbers[i]);
        }
        if (hm.size() != splitNumbers.length){
            return false;
        }
        return true;
    }

}
