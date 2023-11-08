package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class validator {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return strNum.matches("^\\d+$");
    }
    public static boolean validatePurchaseAmount(int money) {
        return money % 1000 == 0;
    }

    public static boolean validateWinningNumber(String winningNumberString) {
        String regex = "^\\d+(,\\d+)*$";
        return winningNumberString.matches(regex);
    }

    public static boolean validateBonusNumber(String bonusNumberString) {
        String regex = "^\\d+$";
        return bonusNumberString.matches(regex);
    }

    public static boolean isUniqueLottoNumber(List<Integer> lottoNumber) {
        Set<Integer> set = new HashSet<>(lottoNumber);
        return set.size() == lottoNumber.size();
    }
}
