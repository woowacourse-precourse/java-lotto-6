package lotto;

import java.util.HashSet;

public class Validator {

    public static String zeroValueError = "[ERROR] 0이 아닌 숫자를 입력하세요.";
    public static String notIntegerError = "[ERROR] 정수를 입력하세요.";
    public static String notInRangeError = "[ERROR] 1~45 범위의 값을 입력하세요.";
    public static String notMultipleOfThousandError = "[ERROR] 1000의 배수의 값을 입력하세요.";
    public static String alreadyExistError = "[ERROR] 이미 입력된 숫자가 포함되어 있습니다.";
    public static String duplicatedError = "[ERROR] 중복된 값을 제외하고 입력하세요.";

    static void isNotZero(int input) {
        if (input != 0) {
            return;
        }
        throw new IllegalArgumentException(zeroValueError);
    }

    static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(notIntegerError);
        }
    }

    static void isInRange(int input) {
        if (input >= 1 & input <= 45) {
            return;
        }
        throw new IllegalArgumentException(notInRangeError);
    }

    static void isMultipleOfThousand(int input) {
        if ((input % 1000) == 0) {
            return;
        }
        throw new IllegalArgumentException(notMultipleOfThousandError);
    }

    static void isAlreadyExist(HashSet<Integer> list, int input) {
        if (!list.contains(input)) {
            return;
        }
        throw new IllegalArgumentException(alreadyExistError);
    }

    static void isSizeInRange(HashSet<Integer> list) {
        if (list.size() != 6) {
            throw new IllegalArgumentException(duplicatedError);
        }
    }

}
