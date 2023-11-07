package lotto;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    static final String prefix = "[ERROR] ";
    private static Validator validator = new Validator();

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
        if (price % 1000 != 0 || price <= 0) {
            throw new IllegalArgumentException(prefix + "잘못된 입력입니다.");
        }
        return price;
    }

    public Set<Integer> validateWinningNumbers(String winningNumbersInput) {
        Set<Integer> winningNumbers = new HashSet<>();
        String[] splittedNumbers = winningNumbersInput.trim().split(",");
        if (splittedNumbers.length != 6) {
            throw new IllegalArgumentException(prefix + "숫자 6개가 아닙니다.");
        }
        for (int i = 0; i < splittedNumbers.length; i++) {
            int num = checkEachNumber(winningNumbers, splittedNumbers, i);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private static int checkEachNumber(Set<Integer> winningNumbers, String[] splittedNumbers, int i) {
        int num = 0;
        try {
            num = Integer.parseInt(splittedNumbers[i]);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(prefix + "1~45 사이의 값이 아닙니다.");
            }
            if (winningNumbers.contains(num)) {
                throw new IllegalArgumentException(prefix + "중복된 값을 포함하고 있습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(prefix + "숫자가 아닙니다.");
        }
        return num;
    }
}
