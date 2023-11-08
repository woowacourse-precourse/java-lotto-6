package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static int LOTTO_BUY_UNIT = 1000;
    private static int LOTTO_LENGTH = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public static int parsePurchaseAmount(String userInput) {
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 아닌 입력입니다.");
        }

        return inputMoney;
    }

    public static void validateUnderZero(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] : 0보다 큰 숫자를 입력해야 합니다.");
        }
    }

    public static void validateDivideThousand(int money) {
        if (money % LOTTO_BUY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] : 입력 금액은 " + LOTTO_BUY_UNIT + " 단위여야 합니다.");
        }
    }

    public static void validateWinNumbersFormatByChar(String winNumbersInput) {
        for (int i = 0; i < winNumbersInput.length(); i++) {
            if (!Character.isDigit(winNumbersInput.charAt(i)) && winNumbersInput.charAt(i) != ',') {
                throw new IllegalArgumentException("[ERROR] : 숫자, 구분자(,)만 입력 가능합니다.");
            }
        }
    }

    public static void validateWinNumbersFormatByLength(String winNumbersInput) {
        String[] splitWinNumbersInput = winNumbersInput.split(",");
        if (splitWinNumbersInput.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] : 당첨 번호는 " + LOTTO_LENGTH + "개여야 합니다.");
        }
    }

    public static void validateWinNumbersFormatBySide(String winNumberInput) {
        if (!Character.isDigit(winNumberInput.charAt(0)) || !Character.isDigit(winNumberInput.charAt(winNumberInput.length() - 1))) {
            throw new IllegalArgumentException("[ERROR] : 입력의 시작과 끝은 숫자여야 합니다");
        }
    }


    public static List<Integer> validateWinNumbersInRange(String winNumbersInput) {
        List<Integer> winNumbers = new ArrayList<>();
        String[] splitWinNumbersInput = winNumbersInput.split(",");
        for (int i = 0; i < splitWinNumbersInput.length; i++) {
            int temp = Integer.parseInt(splitWinNumbersInput[i]);
            if (temp < LOTTO_START_NUMBER || temp > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] : 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winNumbers.add(temp);
        }
        return winNumbers;
    }

    public static void validateWinNumbersByDuplicate(List<Integer> winNumbers) {
        Set<Integer> validateDuplicateSet = new HashSet<>();
        for (int i = 0; i < winNumbers.size(); i++) {
            validateDuplicateSet.add(winNumbers.get(i));
        }
        if (validateDuplicateSet.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] : 중복된 번호는 입력할 수 없습니다.");
        }
    }

    public static int validateBonusNumberInRangeOrIsNumber(String bonusNumberInput) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 아닌 입력입니다.");
        }
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] : 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    public static void validateBonusNumberByDuplicate(int bonusNumber, List<Integer> winNumbers) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] : 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
