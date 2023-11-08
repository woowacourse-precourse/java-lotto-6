package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int PAYMENT_UNIT = 1000;
    private static final int SIZE_LOTTONUM = 6;

    public static boolean isThousandWonUnit(int amount) {
        if ((amount % PAYMENT_UNIT) != 0 || (amount < PAYMENT_UNIT)) {
            return false;
        }

        return true;
    }

    public static boolean validateLottoNumbersAndSize(String inputLottoNumbers) {
        return inputLottoNumbers.matches("([1-3][0-9]|[4][0-5]|[1-9],){5}([1-3][0-9]|[4][0-5]|[1-9])");
    }


    public static boolean isDuplicateLottoNumbers(String[] inputLottoNumberList) {
        Set<String> set = new HashSet<>();
        for (String num : inputLottoNumberList) {
            set.add(num);
        }
        return set.size() != SIZE_LOTTONUM;
    }

    public static boolean validateBonusNumber(String inputBonusNumber) {
        return inputBonusNumber.matches("([1-3][0-9]|[4][0-5]|[1-9])");
    }

    public static boolean isDuplicateAllNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
