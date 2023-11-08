package domain;

import view.ExceptionView;
import view.InputView;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoAmount {
    public static void exceptionMessage(String str) {
        if (!isDigit(str)) {
            ExceptionView.OnlyNumberException();
        } else if (!inputValidate(str)) {
            ExceptionView.thousandUnitException();
        }
    }

    public static boolean isDigit(String str) {
        boolean isNumeric = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
                break;
            }
        }

        return isNumeric;
    }

    private static boolean inputValidate(String input) {
        return Integer.parseInt(input) % 1000 == 0;
    }

    public static void expression(String str) {
        if (!checkExpression(str)) {
            ExceptionView.SeparatorException();
        }
    }

    private static boolean checkExpression(String str) {
        return str.contains(",");
    }

    public static void winningValid(String[] str) {
        duplicateNumber(str);
        validateNumber(str);
        validateRange(str);
    }

    private static void duplicateNumber(String[] str) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, str);

        if (set.size() != str.length) {
            ExceptionView.validateDuplication();
        }
    }

    private static void validateNumber(String[] str) {
        if (str.length != 6) {
            ExceptionView.validate();
        }
    }

    private static void validateRange(String[] str) {
        for (String s : str) {
            int i = InputView.convertToInt(s);
            if (i < 1 || i > 45) {
                ExceptionView.validateRange();
            }
        }
    }

    public static void compareValid(String[] winning, int bonus) {
        for (String s : winning) {
            int i = InputView.convertToInt(s);
            if (i == bonus) ExceptionView.validateDuplication();
        }
    }
}
