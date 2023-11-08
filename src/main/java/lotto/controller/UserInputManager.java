package lotto.controller;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputManager {


    public String getPurchasePriceInput() {
        String purchasePriceInput;
        boolean isOkayToInput;
        do {
            purchasePriceInput = readLine();
            isOkayToInput = isDigit(purchasePriceInput) && isThousandUnit(purchasePriceInput);
            if (!isOkayToInput) {
                System.out.println("[ERROR] 숫자만 입력하실 수 있으며, 1000원 단위로 입력하여야 합니다.");
            }
        } while (!isOkayToInput);
        return purchasePriceInput;
    }

    public String getBonusNumberInput() {
        String bonusNumberInput;
        boolean isOkayToInput;
        do {
            bonusNumberInput = readLine();
            isOkayToInput = isDigit(bonusNumberInput) && isInRange(bonusNumberInput);
            if (!isOkayToInput) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } while (!isOkayToInput);

        return bonusNumberInput;
    }

    public String getWinningNumbersInput() throws IllegalArgumentException {
        String winningNumbers = readLine();
        if (!isDigitList(winningNumbers) || !areInRange(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
        }
        return winningNumbers;
    }

    private boolean isThousandUnit(String input) {
        return Integer.parseInt(input) % 1000 == 0;
    }

    private boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    private boolean isInRange(String input) {
        return Integer.parseInt(input) <= 45 && Integer.parseInt(input) >= 0;
    }

    private boolean isDigitList(String input) {
        List<String> numbers = Arrays.asList(input.split(","));
        if (numbers.size() != 6) {
            return false;
        }
        for (String number : numbers) {
            if (!isDigit(number.trim())) {
                return false;
            }
        }
        return true;
    }


    private boolean areInRange(String input) {
        List<String> numbers = Arrays.asList(input.split(","));
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number.trim());
                if (num < 1 || num > 45) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
