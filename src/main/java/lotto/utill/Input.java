package lotto.utill;

import Validate.ValidateException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public static List<Integer> InputNumbers() {
        List<Integer> resultNumbers = null;
        String inputStringLine = Console.readLine().trim();

        validateInputNumbers(inputStringLine);

        resultNumbers = makeListFromSplitComma(inputStringLine);

        return resultNumbers;
    }

    public static Integer InputNumber() {
        String inputStringLine = Console.readLine().trim();

        validateInputNumber(inputStringLine);

        return Utii.parseInteger(inputStringLine);
    }

    private static List<Integer> makeListFromSplitComma(String inputStringLine) {
        List<Integer> resultNumbers;
        String[] arr;

        arr = Utii.makeArrSplitComma(inputStringLine);
        resultNumbers = Utii.makeListFromArr(arr);

        return resultNumbers;
    }

    private static void validateInputNumbers(String inputStringLine) {
        ValidateException.includeStringExceptionComma(inputStringLine);
        ValidateException.blankCheck(inputStringLine);
        ValidateException.includeBlank(inputStringLine);
        ValidateException.commaStartAndEnd(inputStringLine);
        ValidateException.hasConsecutiveEmptyValues(inputStringLine);
    }

    private static void validateInputNumber(String inputStringLine) {
        ValidateException.containsNonNumericCharacter(inputStringLine);
        ValidateException.includeBlank(inputStringLine);
        ValidateException.blankCheck(inputStringLine);
        ValidateException.negative(inputStringLine);
        ValidateException.zeroNumber(inputStringLine);
    }
}
