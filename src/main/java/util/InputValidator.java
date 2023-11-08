package util;


import error.ErrorMessage;
import java.util.HashSet;
import java.util.List;

public class InputValidator {

    //숫자 확인
    public static void validNumberType(String inputValue) {
        if (!isIntegerFormat(inputValue)) {
            ErrorMessage.INVALID_NUM_TYPE.errorHandle();
        }

    }

    public static <T> boolean isValidListSize(List<T> inputs, int size) {
        return inputs.size() == size;
    }

    public static <T> boolean hasDuplicateNum(List<T> checkNumbers) {
        int unDuplicateSize = (new HashSet<>(checkNumbers)).size();
        return unDuplicateSize != checkNumbers.size();
    }

    public static boolean isValidRangeNum(int input, int minRage, int maxRage) {
        return (minRage <= input) && (input <= maxRage);
    }

    //나누어 떨어질 수 있는지 확인
    public static boolean isDivisible(Integer dividend, Integer divisor) {
        if (divisor == 0) {
            return false;
        }

        return (dividend % divisor) == 0;
    }


    private static boolean isIntegerFormat(String input) {
        if (input == null || input.isEmpty() || input.isBlank() || (input.charAt(0) == '0')) {
            return false;
        }
        try {
            Integer.parseInt(input, 10);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}

