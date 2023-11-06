package lotto.util;

import lotto.view.InputView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUM = 6;
    private static final int BONUS_NUMBER_NUM = 1;

    public static void purchasePrice(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void winNumberNum(List<Integer> winNumber) {
        if (winNumber.size() != LOTTO_NUM) {
            throw new IllegalArgumentException();
        }
    }

    public static void winNumberDuplication(List<Integer> winNumber) {
        Set<Integer> setWinNumber = winNumber.stream().collect(Collectors.toSet());
        if (winNumber.size() != setWinNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void bonusNumberNum(int bonusNumber) {
        if (bonusNumber != BONUS_NUMBER_NUM) {
            throw new IllegalArgumentException();
        }
    }

//    public static void checkPositiveOrNegative(int num) {
//        if (num < 0) {
//            throw new IllegalArgumentException();
//        }
//    }
}
