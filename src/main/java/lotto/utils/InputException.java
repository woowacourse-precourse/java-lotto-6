package lotto.utils;

import lotto.domain.PrintMessage;

import java.util.*;

public class InputException {

    private InputException() {
    }

    public static void validatePurchaseAmount(String input) {
        isDigit(input);
        isThousandUnit(Integer.parseInt(input));
    }

    public static List<Integer> validateWinningNumber(String input) {
        isContainComma(input);
        List<Integer> list = new ArrayList<>(validateList(input.split(",")));
        checkSize(list);
        isDuplication(list);
        Collections.sort(list);
        return list;
    }

    public static void validateBonusNumber(String input, List<Integer> list) {
        isDigit(input);
        isBetweenOneAndFourtyfive(Integer.parseInt(input));
        isContainNumber(list, Integer.parseInt(input));
    }

    public static List<Integer> validateList(String[] arr) {
        List<Integer> list = new ArrayList<>();

        for (String s : arr) {
            isDigit(s);
            isBetweenOneAndFourtyfive(Integer.parseInt(s));
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public static void isDigit(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(PrintMessage.ONLY_DIGIT);
            }
        }
    }

    public static void isThousandUnit(int num) {
        if (num % 1000 != 0)
            throw new IllegalArgumentException(PrintMessage.ONLY_THOUSAND_UNIT);
    }

    public static void isContainComma(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException(PrintMessage.ONLY_SPLIT_COMMA);
    }

    public static void isBetweenOneAndFourtyfive(int num) {
        if (num < 1 || num > 45)
            throw new IllegalArgumentException(PrintMessage.BETWEEN_ONE_AND_FORTYFIVE);
    }

    public static void isDuplication(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        if (list.size() != set.size())
            throw new IllegalArgumentException(PrintMessage.NOT_DUPLICATION);
    }

    public static void checkSize(List<Integer> list) {
        if (list.size() != 6)
            throw new IllegalArgumentException(PrintMessage.ONLY_SIX_NUMBER);
    }

    public static void isContainNumber(List<Integer> list, int number) {
        if (list.contains(number))
            throw new IllegalArgumentException(PrintMessage.NOT_DUPLICATION);
    }
}
