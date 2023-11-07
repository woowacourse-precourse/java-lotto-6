package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusinessVaildator {
    private static final int currencyAmount = 1000;

    public static void vaildateCurrencyAmount(int purchaseAmount) {
        if (purchaseAmount % currencyAmount != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 단위가 아닙니다. 다시 입력해주세요.");
        }
    }
    public static void validateNumberRule(List<Integer> numbers) {
        InvalidNumberOfNumbersException(numbers);
        DuplicateNumbersException(numbers);
        OutOfRangeException(numbers);
    }
//    public static void validateBonusRule(int bonusNumber) {
//
//    }
    private static void InvalidNumberOfNumbersException(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다. 다시 입력해주세요.");
        }
    }
    private static void DuplicateNumbersException(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>();
        for (int number : numbers) {
            setNumbers.add(number);
        }
        if (setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 있습니다. 다시 입력해주세요.");
        }
    }
    private static void OutOfRangeException(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 범위 밖의 수가 있습니다. 다시 입력해주세요.");
            }
        }
    }

    /*
private int[] convertToIntArr(String inputNumber) {
    String[] strNumbers = inputNumber.split(",");
    return Arrays.stream(strNumbers)
            .mapToInt(Integer::parseInt)
            .toArray();
}
private int convertToInt(String inputNumber) {
    return Integer.parseInt(inputNumber);
}
*/
}