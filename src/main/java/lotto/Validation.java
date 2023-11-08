package lotto;

import java.util.HashMap;
import java.util.Map;

public class Validation {
    private static final String VALID_NUMBER_ERROR = "[ERROR] : 입력값이 숫자 형식이 아닙니다.";
    private static final String VALID_UNIT_ERROR = "[ERROR] : 입력값이 1000의 배수가 아닙니다.";
    private static final String VALID_BLANK_ERROR = "[ERROR] : 빈 입력값이 존재합니다.";
    private static final String VALID_SIZE_ERROR = "[ERROR] : 입력값의 개수가 맞지 않습니다.";
    private static final String VALID_RANGE_ERROR = "[ERROR] : 1부터 45까지의 숫자만 입력해주세요.";
    private static final String VALID_DUPLICATE_ERROR = "[ERROR] : 이미 사용한 값이 있습니다.";
    private static Map<Integer, Boolean> pickedNumbers = new HashMap<>();

    public static void validPurchaseMoney(String data) {
        if (!validNumber(data))
            throw new NumberFormatException(VALID_NUMBER_ERROR);
        if (!validUnit(Integer.parseInt(data)))
            throw new IllegalStateException(VALID_UNIT_ERROR);
    }

    public static void validWinningNumbers(String data) {
        pickedNumbers.clear();
        if (!validNumbers(data))
            throw new NumberFormatException(VALID_NUMBER_ERROR);
        if (!validBlank(data))
            throw new IllegalStateException(VALID_BLANK_ERROR);
        if (!validSize(data, 6))
            throw new IllegalStateException(VALID_SIZE_ERROR);
        if (!validRange(data))
            throw new IllegalStateException(VALID_RANGE_ERROR);
        if(!validDuplication(data))
            throw new IllegalStateException(VALID_DUPLICATE_ERROR);
    }

    public static void validBonusNumber(String data) {
        if (!validNumber(data))
            throw new NumberFormatException(VALID_NUMBER_ERROR);
        if (!validSize(data, 1))
            throw new IllegalStateException(VALID_SIZE_ERROR);
        if (!validRange(data))
            throw new IllegalStateException(VALID_RANGE_ERROR);
        if(!validDuplication(data))
            throw new IllegalStateException(VALID_DUPLICATE_ERROR);
    }

    public static boolean validNumber(String data) {
        return data.matches("^[0-9]+$");
    }

    public static boolean validNumbers(String data) {
        return data.matches("^[0-9,]+$");
    }

    public static boolean validRange(String data) {
        String[] splitData = data.split(",");
        for (String number : splitData) {
            int pickedNumber = Integer.parseInt(number);
            if (pickedNumber > 45 || pickedNumber < 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean validDuplication(String data) {
        String[] splitData = data.split(",");

        for (String number : splitData) {
            int pickedNumber = Integer.parseInt(number);
            if (pickedNumbers.getOrDefault(pickedNumber, false)) {
                return false;
            }
            pickedNumbers.put(pickedNumber, true);
        }

        return true;
    }

    public static boolean validUnit(int data) {
        if (data < 1000)
            return false;
        return data % 1000 == 0;
    }

    public static boolean validBlank(String data) {
        String[] winningNumbers = data.split(",");
        for (String number : winningNumbers) {
            if (number.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public static boolean validSize(String data, int size) {
        String[] winningNumbers = data.split(",");
        return winningNumbers.length == size;
    }
}
