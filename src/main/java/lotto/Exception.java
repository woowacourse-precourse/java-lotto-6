package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

    public static void validateLottoNumbers(List<Integer> numbers) {
        notSixNumbers(numbers);
        for (Integer number : numbers) {
            numberNotInRange(number);
        }
        duplicateNumber(numbers);
    }

    public static void validateBonusNumber(List<Integer> wins, Integer bonus) {
        numberNotInRange(bonus);
        wins.add(bonus);
        duplicateNumber(wins);
    }

    public static void validateMoney(String input) {
        notParsableNumber(input);
        int money = Integer.parseInt(input);
        notPositiveNumber(money);
        notDividedWithThousand(money);
    }

    private static void notSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 가지고 있지 않습니다.");
        }
    }

    private static void numberNotInRange(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45에 속하지 않는 숫자가 포함되어 있습니다.");
        }
    }

    private static void duplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복 숫자가 존재합니다.");
        }
    }

    private static void notParsableNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값을 정수로 변환할 수 없습니다.");
        }
    }

    private static void notPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 0 이하의 숫자입니다.");
        }
    }

    private static void notDividedWithThousand(int number) {
        int remainder = number % 1000;
        if (remainder > 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나눠 떨어지지 않습니다.");
        }
    }
}
