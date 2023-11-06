package lotto;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public int parsePurchaseAmount(String userInput) {
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 아닌 입력입니다.");
        }

        return inputMoney;
    }

    public void validateUnderZero(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] : 0보다 큰 숫자를 입력해야 합니다.");
        }
    }

    public void validateDivideThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 입력 금액은 1000 단위여야 합니다.");
        }
    }

    public void validateWinNumbersFormatByChar(String winNumbersInput) {
        for (int i = 0; i < winNumbersInput.length(); i++) {
            if (!Character.isDigit(winNumbersInput.charAt(i)) && winNumbersInput.charAt(i) != ',') {
                throw new IllegalArgumentException("[ERROR] : 숫자, 구분자(,)만 입력 가능합니다.");
            }
        }
    }

    public void validateWinNumbersFormatByLength(String winNumbersInput) {
        String[] splitWinNumbersInput = winNumbersInput.split(",");
        if (splitWinNumbersInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] : 당첨 번호는 6개여야 합니다.");
        }
    }

    public void validateWinNumbersFormatBySide(String winNumberInput) {
        if (!Character.isDigit(winNumberInput.charAt(0)) || !Character.isDigit(winNumberInput.charAt(winNumberInput.length() - 1))) {
            throw new IllegalArgumentException("[ERROR] : 입력의 시작과 끝은 숫자여야 합니다");
        }
    }


    public int[] validateWinNumbersInRange(String winNumbersInput) {
        int[] winNumbers = new int[6];
        String[] splitWinNumbersInput = winNumbersInput.split(",");
        for (int i = 0; i < splitWinNumbersInput.length; i++) {
            int temp = Integer.parseInt(splitWinNumbersInput[i]);
            if (temp < 0 || temp > 45) {
                throw new IllegalArgumentException("[ERROR] : 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winNumbers[i] = temp;
        }
        return winNumbers;
    }

    public void validateWinNumbersByDuplicate(int[] winNumbers) {
        Set<Integer> validateDuplicateSet = new HashSet<>();
        for (int i = 0; i < winNumbers.length; i++) {
            validateDuplicateSet.add(winNumbers[i]);
        }
        if (validateDuplicateSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] : 중복된 번호는 입력할 수 없습니다.");
        }
    }

    public int validateBonusNumberInRangeOrIsNumber(String bonusNumberInput) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 아닌 입력입니다.");
        }
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] : 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    public void validateBonusNumberByDuplicate(int bonusNumber, int[] winNumbers) {
        for (int i = 0; i < winNumbers.length; i++) {
            if (winNumbers[i] == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] : 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        }
    }

}
