package lotto.validation;

import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validation {

    public static void validateDuplicationList(List<Integer> list) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(list);
        if (list.size() != nonDuplicateNumbers.size()) {
            ErrorMessage.duplicatedNumberInListError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateSize(List<Integer> list, int length) {
        if (list.size() != length) {
            ErrorMessage.lengthError(length);
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberListInRange(List<Integer> list, int max, int min) {
        for (int number : list) {
            validateNumberInRange(number, max, min);
        }
    }

    private static void validateNumberInRange(int number, int min, int max) {
        if (number > max || number < min) {
            ErrorMessage.numberInRangeError(min, max);
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicateBonus(List<Integer> winningNumbers, int bonusNumber) {
        boolean hasDuplicate = winningNumbers.stream()
                .anyMatch(number -> number == bonusNumber);
        if (hasDuplicate) {
            ErrorMessage.duplicationListError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateAmountUnit(int amount, int unit) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMinPurchaseAmount(int amount, int minAmount) {
        if (amount < minAmount) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInput(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            ErrorMessage.inappropriateInput();
            throw new IllegalArgumentException();
        }
    }

}
