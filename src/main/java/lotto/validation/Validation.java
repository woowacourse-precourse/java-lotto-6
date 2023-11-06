package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validation {

    public static void validateDuplicationList(List<Integer> list) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(list);
        if (list.size() != nonDuplicateNumbers.size()) {
            //Message 출력
            throw new IllegalArgumentException();
        }
    }

    public static void validateSize(List<Integer> list, int length) {
        if (list.size() != length) {
            //Message 출력
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberListInRange(List<Integer> list, int max, int min) {
        for (int number : list) {
            validateNumberInRange(number, max, min);
        }
    }

    private static void validateNumberInRange(int number, int max, int min) {
        if (number < max || number > min) {
            //message 출력
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicateBonus(List<Integer> winningNumbers, int bonusNumber) {
        boolean hasDuplicate = winningNumbers.stream()
                .anyMatch(number -> number == bonusNumber);
        if (hasDuplicate) {
            //Mesaage 출력
            throw new IllegalArgumentException();
        }
    }

    public static void validateAmountUnit(int amount , int unit ) {
        if(amount % unit != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void ValidateMinPurchaseAmount(int amount, int minAmount) {
        if(amount < minAmount) {
            throw new IllegalArgumentException();
        }
    }

}
