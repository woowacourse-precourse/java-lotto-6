package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    static final String prefix = "[ERROR] ";

    private static Validator validator = new Validator();

    static final int MONEY_UNIT = 1000;
    static final int START_NUM = 1;
    static final int END_NUM = 45;

    private Validator() {
    }

    public static Validator getInstance() {
        return validator;
    }

    public static int validatePrice(String input) {
        int price = 0;
        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(prefix + "숫자가 아닙니다.");
        }
        if (price % MONEY_UNIT != 0 || price <= 0) {
            throw new IllegalArgumentException(prefix + "잘못된 입력입니다.");
        }
        return price;
    }

    public List<Integer> validateWinningNumbers(String winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splittedNumbers = winningNumbersInput.trim().split(",");
        for (int i = 0; i < splittedNumbers.length; i++) {
            int num = checkEachNumber(splittedNumbers, i);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private static int checkEachNumber(String[] splittedNumbers, int i) {
        String oneNum = splittedNumbers[i];
        validateNumberFormat(oneNum);
        int num = Integer.parseInt(oneNum);
        validateNumberScope(num);
        return num;
    }

    public int validateBonusNumber(String bonusNumberInput, Lotto lotto) {
        validateNumberFormat(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateNumberScope(bonusNumber);
        if (lotto.containsNum(bonusNumber)) {
            throw new IllegalArgumentException(prefix + "당첨 번호와 겹치는 번호입니다.");
        }
        return bonusNumber;
    }

    private static void validateNumberScope(int num) {
        if (num < START_NUM || num > END_NUM) {
            throw new IllegalArgumentException(prefix + "1~45 사이의 값이 아닙니다.");
        }
    }

    private static void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(prefix + "숫자가 아닙니다.");
        }
    }
}
