package lotto.utill;

import Validate.ValidateException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public static List<Integer> InputNumbers() {
        List<Integer> results = null;
        String[] arr = null;
        String inputStringLine = Console.readLine().trim();

        validateInputNumbers(inputStringLine);

        arr = Utii.makeArrSplitComma(inputStringLine);
        results = Utii.makeListFromArr(arr);

        return results;
    }

    private static void validateInputNumbers(String inputStringLine) {
        ValidateException.includeStringExceptionComma(inputStringLine);
        ValidateException.blankCheck(inputStringLine);
        ValidateException.includeBlank(inputStringLine);
        ValidateException.commaStartAndEnd(inputStringLine);
        ValidateException.hasConsecutiveEmptyValues(inputStringLine);
    }

    public static Integer InputNumber() {
        String inputStringLine = Console.readLine().trim();

        validateInputNumber(inputStringLine);

        return Utii.parseInteger(inputStringLine);
    }

    private static void validateInputNumber(String inputStringLine) {
        ValidateException.containsNonNumericCharacter(inputStringLine);
        ValidateException.includeBlank(inputStringLine);
        ValidateException.blankCheck(inputStringLine);
        ValidateException.negative(inputStringLine);
        ValidateException.zeroNum(inputStringLine);
    }
}
