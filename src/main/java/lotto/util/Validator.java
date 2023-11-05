package lotto.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    public static void purchasePrice(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void winNumberNum(List<Integer> winNumber) {
        if (winNumber.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void winNumberDuplication(List<Integer> winNumber) {
        Set<Integer> setWinNumber = winNumber.stream().collect(Collectors.toSet());
        if (winNumber.size() != setWinNumber.size()) {
            throw new IllegalArgumentException();
        }
    }
}
