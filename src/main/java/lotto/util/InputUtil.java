package lotto.util;

import lotto.validation.ViewValidate;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {
    private InputUtil() {
    }

    public static int enterMoneyWhileVerifying() {
        try {
            String money = readLine().trim();
            ViewValidate.validateNotNull(money);
            ViewValidate.validateNotSpaceOrEmpty(money);
            return ViewValidate.validateAndConvertString2Int(money);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            return enterMoneyWhileVerifying();
        }
    }

    public static List<Integer> enterNumbersWhileVerifying() {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (String number : readLine().trim().split(",")) {
                ViewValidate.validateNotNull(number);
                ViewValidate.validateNotSpaceOrEmpty(number);
                numbers.add(ViewValidate.validateAndConvertString2Int(number));
            }
            return numbers;
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            return enterNumbersWhileVerifying();
        }
    }
}
