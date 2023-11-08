package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserInputValidator {
    public static int isValidBuyingPrice(String input) {
        if (!isPositiveInteger(input)) {
            throw new IllegalArgumentException("구매 금액은 양의 정수여야 합니다.");
        }
        int buyingPrice = Integer.parseInt(input);
        if (buyingPrice % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
        }
        return buyingPrice;
    }
    public static List<Integer> isValidWinNumbers(String input) {
        List<Integer> numbers = splitNumbers(input);
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        Collections.sort(numbers);
        return numbers;
    }
    public static int isValidBonusNumbers(String input, List<Integer> numbers) {
        int bonusNumber;
        if (!isPositiveInteger(input)) {
            throw new IllegalArgumentException("로또 번호는 양의 정수여야 합니다.");
        }
        bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 일치하지 않아야 합니다.");
        }
        return bonusNumber;
    }
    private static boolean isPositiveInteger(String str) {
        try {
            int num = Integer.parseInt(str);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static List<Integer> splitNumbers(String userInput) {
        String[] inputNumbers = userInput.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputNumbers) {
            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
            }
        }
        return numbers;
    }
}
