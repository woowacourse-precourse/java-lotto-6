package lotto.utill;

import Validate.ValidateException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public static List<Integer> InputNumbers() {
        List<Integer> results = null;
        String[] arr = null;
        String inputStringLine = Console.readLine().trim();

        ValidateException.includeString(inputStringLine);
        ValidateException.blankCheck(inputStringLine);
        ValidateException.includeBlank(inputStringLine);
        ValidateException.includeSpecialString(inputStringLine);
        ValidateException.commaStartAndEnd(inputStringLine);
        ValidateException.hasConsecutiveEmptyValues(inputStringLine);

        arr = Utii.makeArrSplitComma(inputStringLine);
        results = Utii.makeListFromArr(arr);

        return results;
    }

    public static Integer InputNumber() {
        String inputStringLine = Console.readLine().trim();

        ValidateException.blankCheck(inputStringLine);
        ValidateException.includeBlank(inputStringLine);
        ValidateException.negative(inputStringLine);
        ValidateException.includeString(inputStringLine);
        ValidateException.includeSpecialString(inputStringLine);
        ValidateException.zeroNum(inputStringLine);

        return Utii.parseInteger(inputStringLine);
    }
}
